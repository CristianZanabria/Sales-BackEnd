package com.zdevs.service.impl;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.model.Sale;
import com.zdevs.model.SaleDetail;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.repo.ISaleRepo;
import com.zdevs.service.ISaleService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static  java.util.stream.Collectors.*;

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

    @Override
    public String getBestSellerPerson() {
        Map<String,Double> byUser = repo.findAll()
                .stream()
                .collect(groupingBy(s -> s.getUser().getUsername(),summingDouble(Sale::getTotal)));
        //System.out.println(byUser);
        return Collections.max(byUser.entrySet(),Comparator.comparingDouble(Map.Entry::getValue)).getKey();
    }

    @Override
    public Map<String, Long> getSalesCountBySeller() {
        return repo.findAll()
                .stream()
                .collect(groupingBy(s -> s.getUser().getUsername(),counting()));
    }

    @Override
    public Map<String, Double> getMostSellerProduct() {
        Stream<Sale> saleStream = repo.findAll().stream();
        Stream<List<SaleDetail>> listStream = saleStream.map(Sale::getDetails);

        Stream<SaleDetail> streamDetail = listStream.flatMap(Collection::stream); // list -> list.stream()
        Map<String, Double> byProduct = streamDetail
                .collect(groupingBy(d -> d.getProduct().getName(), summingDouble(SaleDetail::getQuantity)));
        return byProduct.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry:: getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new //new LinkedHashMap<>()

                ));
    }
}
