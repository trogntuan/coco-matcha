package aidd.fz.reservation.repository;

import org.apache.ibatis.annotations.*;

import aidd.fz.reservation.entity.Reservation;

import java.util.List;

@Mapper
public interface ReservationMapper {
    @Select("SELECT * FROM RESERVATION WHERE seat_id = #{seatId} AND (status = 'RESERVED' OR status = 'IN_USE')")
    List<Reservation> findActiveReservationsBySeatId(Integer seatId);

    @Insert("INSERT INTO RESERVATION (employee_id, seat_id, start_time, end_time, status, created_at) " +
            "VALUES (#{employeeId}, #{seatId}, #{startTime}, #{endTime}, 'PENDING', NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Reservation reservation);

    @Select("SELECT * FROM RESERVATION WHERE id = #{id}")
    Reservation findById(Integer id);
}
