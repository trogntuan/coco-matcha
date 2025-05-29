package aidd.fz.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aidd.fz.reservation.common.constant.ReservationStatus;
import aidd.fz.reservation.entity.Reservation;
import aidd.fz.reservation.entity.Seat;
import aidd.fz.reservation.repository.ReservationMapper;
import aidd.fz.reservation.repository.SeatMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private SeatMapper seatMapper;

    public Reservation createReservation(Integer employeeId, Integer seatId, String date, String startTime, String endTime) {
        // Validate input data format
        if (seatId == null || date == null || startTime == null || endTime == null) {
            throw new IllegalArgumentException("Invalid data entry.");
        }

        // Validate seat status
        Seat seat = seatMapper.findById(seatId);
        if (seat == null || "BROKEN".equals(seat.getStatus())) {
            throw new IllegalArgumentException("The seat is unavailable or broken.");
        }

        // Validate seat availability
        List<Reservation> activeReservations = reservationMapper.findActiveReservationsBySeatId(seatId);
        LocalDateTime requestedStartTime = LocalDateTime.parse(date + "T" + startTime);
        LocalDateTime requestedEndTime = LocalDateTime.parse(date + "T" + endTime);

        for (Reservation reservation : activeReservations) {
            if (requestedStartTime.isBefore(reservation.getEndTime().toLocalDateTime()) &&
                requestedEndTime.isAfter(reservation.getStartTime().toLocalDateTime())) {
                throw new IllegalArgumentException("An existing reservation exists.");
            }
        }

        // Validate future reservation time
        if (requestedStartTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("The requested reservation period must be in the future.");
        }

        // Validate maximum booking time (8 hours)
        if (requestedEndTime.minusHours(8).isAfter(requestedStartTime)) {
            throw new IllegalArgumentException("The maximum time for booking is 8 hours.");
        }

        // Create and save the reservation
        Reservation reservation = new Reservation();
        reservation.setEmployeeId(employeeId);
        reservation.setSeatId(seatId);
        reservation.setStartTime(Timestamp.valueOf(requestedStartTime));
        reservation.setEndTime(Timestamp.valueOf(requestedEndTime));
        reservation.setStatus(ReservationStatus.PENDING);

        reservationMapper.insert(reservation);

        return reservation;
    }
}
