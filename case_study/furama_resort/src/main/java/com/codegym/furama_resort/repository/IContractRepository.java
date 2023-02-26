package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.dto.IContractDTO;
import com.codegym.furama_resort.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select `contract`.id as contractId, \n" +
            "`facility`.name as facilityName, \n" +
            "`customer`.name as customerName, \n" +
            "`contract`.start_date as startDate, \n" +
            "`contract`.end_date as endDate, \n" +
            "`contract`.deposit as deposit, \n" +
            "(sum(ifnull(`attach_facility`.cost, 0) * ifnull(`contract_detail`.quantity, 0)) + ifnull(`facility`.cost, 0)) as totalCost\n" +
            "from `contract`\n" +
            "left join `customer` on `customer`.id = `contract`.costomer_id \n" +
            "left join `customer_type` on `customer`.customer_type_id = `customer_type`.id  \n" +
            "left join `facility` on `contract`.facility_id = `facility`.id \n" +
            "left join `contract_detail` on `contract`.id = `contract_detail`.contract_id \n" +
            "left join `attach_facility` on `contract_detail`.attach_facility_id = `attach_facility`.id \n" +
            "group by `contract`.id", nativeQuery = true)
    Page<IContractDTO> findAllContract(Pageable pageable);
    @Query(value = "select * from contract where deposit =:deposit and end_date =:endDate and " +
            "start_date =:startDate and costomer_id =:customerId and employee_id =:employeeId and facility_id =:facilityId",nativeQuery = true)
    Contract findNewContract(@Param("deposit") double deposit, @Param("endDate")Date endDate,@Param("startDate") Date startDate,
                             @Param("customerId") int customerId,@Param("employeeId") int employeeId,
                             @Param("facilityId") int facilityId);
}
