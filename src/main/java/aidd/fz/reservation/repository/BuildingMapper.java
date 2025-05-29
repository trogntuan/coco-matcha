package aidd.fz.reservation.repository;

import org.apache.ibatis.annotations.*;

import aidd.fz.reservation.entity.Building;

import java.util.List;

@Mapper
public interface BuildingMapper {
    @Select("SELECT * FROM BUILDING")
    List<Building> findAll();

    @Select("SELECT * FROM BUILDING WHERE id = #{id}")
    Building findById(Integer id);
}
