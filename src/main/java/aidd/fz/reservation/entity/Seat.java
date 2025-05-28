package aidd.fz.reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Seat {
    private Integer id;
    private Integer floorId;
    private String name;
    private String status;
    private List<Reservation> reservations; // Assuming a seat can have multiple reservations
}
