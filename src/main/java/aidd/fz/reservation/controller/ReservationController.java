package aidd.fz.reservation.controller;

import aidd.fz.reservation.dto.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import aidd.fz.reservation.config.JwtTokenUtil;
import aidd.fz.reservation.dto.ResponseMessage;
import aidd.fz.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequest request, JwtAuthenticationToken authentication) {
        try {
            // Extract employeeId from access token
            Integer employeeId = JwtTokenUtil.getEmployeeIdFromAccessToken(authentication);

            // Create reservation
            reservationService.createReservation(employeeId, request.getSeatId(), request.getDate(), request.getStartTime(), request.getEndTime());

            return ResponseEntity.ok(new ResponseMessage("RS001", "Reservation request complete"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("RE001", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("SE", "System error."));
        }
    }
}
