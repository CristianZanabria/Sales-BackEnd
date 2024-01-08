package com.zdevs.repo;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.model.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISaleRepo extends IGenericRepo<Sale, Integer> {

    /////////////nativeQuery/////////////////
    @Query(value = "select * from fn_sales()", nativeQuery = true)
    List<Object[]> callProcedure();

    @Query(value = "select * from fn_sales()", nativeQuery = true)
    List<IProcedureDto> callProcedure2();

    @Query(name = "Sale.fn_sales", nativeQuery = true)
    List<ProcedureDTO> callProcedure3();

    @Procedure(procedureName = "pr_sales")
    void callProcedure4();
    @Procedure(procedureName = "pr_salesParameter")
    List<IProcedureDto> callProcedure5(@Param("p_id_client") Integer idClient);
}






















