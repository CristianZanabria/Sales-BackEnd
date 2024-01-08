package com.zdevs.service;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.model.Sale;

import java.util.List;

public interface ISaleService extends ICRUD<Sale, Integer> {
    List<ProcedureDTO> callProcedure();
    List<IProcedureDto> callProcedure2();
    List<ProcedureDTO> callProcedure3();
    void callProcedure4();
    Sale getSaleMostExpensive(); //OPTENER LA VENTA MAS CARA


}
