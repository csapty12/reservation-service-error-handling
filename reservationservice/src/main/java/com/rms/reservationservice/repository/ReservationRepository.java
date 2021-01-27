package com.rms.reservationservice.repository;

import com.rms.reservationservice.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, String> {}