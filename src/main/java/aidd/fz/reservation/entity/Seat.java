package aidd.fz.reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import aidd.fz.reservation.common.constant.SeatStatus;

@Data
@NoArgsConstructor
public class Seat {
    private Integer id;
    private Integer floorId;
    private String name;
    private SeatStatus status;
    private List<Reservation> reservations; // Assuming a seat can have multiple reservations
}
