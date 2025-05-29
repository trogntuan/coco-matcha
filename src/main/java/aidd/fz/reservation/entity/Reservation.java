package aidd.fz.reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import aidd.fz.reservation.common.constant.ReservationStatus;

@Data
@NoArgsConstructor
public class Reservation {
    private Integer id;
    private Integer employeeId;
    private Integer seatId;
    private Timestamp startTime;
    private Timestamp endTime;
    private ReservationStatus status;
    private Timestamp checkInAt;
    private Timestamp createdAt;
    private Integer extendedFromReservationId;
    private Reservation extendedFromReservation; // Assuming a reservation can extend from another reservation
}
