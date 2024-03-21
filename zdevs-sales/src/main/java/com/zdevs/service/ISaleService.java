package com.zdevs.service;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.model.Sale;

import java.util.List;
import java.util.Map;

public interface ISaleService extends ICRUD<Sale, Integer> {
    List<ProcedureDTO> callProcedure();
    List<IProcedureDto> callProcedure2();
    List<ProcedureDTO> callProcedure3();
    void callProcedure4();
    Sale getSaleMostExpensive(); //OBTENER LA VENTA MAYOR
    String getBestSellerPerson(); //Obtener el mejor vendedor
    Map<String, Long> getSalesCountBySeller(); // contar cantidad de ventas por vendedor

    Map<String, Double> getMostSellerProduct();


}
