package com.rms.reservationservice.service;

import com.rms.reservationservice.entity.ReservationEntity;
import com.rms.reservationservice.model.Reservation;
import com.rms.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import static com.rms.reservationservice.utils.IdGenerator.generateId;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    private static final int LARGE_GROUP_OF_GUESTS = 6;
    private static final int ONE_HOUR = 1;
    private static final int TWO_HOURS = 2;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        Reservation.ReservationBuilder reservationBuilder = reservation.toBuilder();
        if (reservation.getId() == null) {
            reservationBuilder.id(generateId(reservation.getFirstName(), reservation.getLastName()));
        }
        if (reservation.getNumberOfGuests() < LARGE_GROUP_OF_GUESTS) {
            reservationBuilder.duration(ONE_HOUR);
        } else {
            reservationBuilder.duration(TWO_HOURS);
        }
        Reservation updatedReservation = reservationBuilder.build();
        ReservationEntity reservationEntity = ReservationEntity.from(updatedReservation);
        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);
        return Reservation.from(savedEntity);
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        return reservationRepository.findById(reservationId)
                .map(Reservation::from)
                .get();
    }

    @Override
    public Reservation updateReservation(String reservationId, Reservation reservation) {
        Reservation reservationWithId = reservation.toBuilder().id(reservationId).build();
        return saveReservation(reservationWithId);
    }

    @Override
    public void deleteReservation(String reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
