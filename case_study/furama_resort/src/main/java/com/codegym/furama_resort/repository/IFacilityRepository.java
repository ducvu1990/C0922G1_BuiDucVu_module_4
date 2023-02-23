package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from furama_resort.facility where name like concat('%',:name,'%')" +
            " and facility_type_id like concat('%',:FacilityTypeName,'%')", nativeQuery = true)
    Page<Facility> findByNameContaining(@Param("name") String name, @Param("FacilityTypeName") String FacilityTypeName,
                                        Pageable pageable);
    Facility findByName(String name);
}
