package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.dto.IAttachFacilityDTO;
import com.codegym.furama_resort.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "SELECT `attach_facility`.cost, `attach_facility`.name, `contract_detail`.quantity FROM furama_resort.`attach_facility`\n" +
            "join `contract_detail` on `contract_detail`.attach_facility_id = `attach_facility`.id\n" +
            "join `contract` on `contract`.id = `contract_detail`.contract_id\n" +
            "where `contract`.id = :id",nativeQuery = true)
    List<IAttachFacilityDTO> findAllAttachFacilityByContractId(@Param("id") int id);
}
