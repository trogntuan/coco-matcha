package aidd.fz.reservation.repository;

import org.apache.ibatis.annotations.*;

import aidd.fz.reservation.entity.Floor;

import java.util.List;

@Mapper
public interface FloorMapper {
    @Select("SELECT * FROM FLOOR WHERE building_id = #{buildingId}")
    List<Floor> findByBuildingId(Integer buildingId);

    @Select("SELECT * FROM FLOOR WHERE id = #{id}")
    Floor findById(Integer id);
}
