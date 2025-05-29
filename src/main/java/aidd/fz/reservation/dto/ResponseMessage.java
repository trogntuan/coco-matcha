package aidd.fz.reservation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseMessage {
    private String msgCd;
    private String msgDesc;

    public ResponseMessage(String msgCd, String msgDesc) {
        this.msgCd = msgCd;
        this.msgDesc = msgDesc;
    }
}

