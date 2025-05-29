package aidd.fz.reservation.repository;

import org.apache.ibatis.annotations.*;

import aidd.fz.reservation.common.constant.SeatStatus;
import aidd.fz.reservation.entity.Seat;

@Mapper
public interface SeatMapper {
    @Select("SELECT * FROM SEAT WHERE id = #{id}")
    Seat findById(Integer id);

    @Update("UPDATE SEAT SET status = #{status} WHERE id = #{id}")
    void updateStatus(Integer id, SeatStatus status);
}
