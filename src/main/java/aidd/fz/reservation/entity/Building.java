package aidd.fz.reservation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Building {
    private Integer id;
    private String name;
    private String address;
    private List<Floor> floors; // Assuming a building can have multiple floors
}
