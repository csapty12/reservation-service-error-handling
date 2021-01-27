package com.rms.reservationservice.service;

import com.rms.reservationservice.model.Reservation;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation); //1
    Reservation getReservationById(String reservationId); //2
    Reservation updateReservation(String reservationId, Reservation reservation); //3
    void deleteReservation(String reservationId); //4
}
