package aidd.fz.reservation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationRequest {
    private Integer seatId;
    private String date;
    private String startTime;
    private String endTime;
}
