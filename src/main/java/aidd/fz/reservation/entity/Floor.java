package aidd.fz.reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Floor {
    private Integer id;
    private Integer buildingId;
    private Integer floor;
    private List<Seat> seats; // Assuming a floor can have multiple seats
}
