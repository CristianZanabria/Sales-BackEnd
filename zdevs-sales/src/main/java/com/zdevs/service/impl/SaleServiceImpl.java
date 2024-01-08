package com.zdevs.service.impl;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.model.Sale;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.repo.ISaleRepo;
import com.zdevs.service.ISaleService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale, Integer> implements ISaleService {

    //@Autowired
    private final ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<ProcedureDTO> callProcedure() {
        List<ProcedureDTO> list = new ArrayList<>();
       repo.callProcedure().forEach( e ->{
           ProcedureDTO dto = new ProcedureDTO();
           dto.setQuantityfn((Integer) e[0]);
           dto.setDatetimefn((String)e[1]);
           list.add(dto);
       });
       return list;
    }

    @Override
    public List<IProcedureDto> callProcedure2() {
        return repo.callProcedure2();
    }

    @Override
    public List<ProcedureDTO> callProcedure3() {
        return repo.callProcedure3();
    }

    @Override
    public void callProcedure4() {
        repo.callProcedure4();
    }

    @Override
    public Sale getSaleMostExpensive() {
        return repo.findAll()
                .stream()
                .max(Comparator.comparing(Sale::getTotal ))
                .orElse(new Sale());
    }
}
