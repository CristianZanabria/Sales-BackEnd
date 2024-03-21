package com.zdevs.controller;

import com.zdevs.dto.IProcedureDto;
import com.zdevs.dto.ProcedureDTO;
import com.zdevs.dto.SaleDTO;
import com.zdevs.model.Sale;
import com.zdevs.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {


    //@Autowired
    private final ISaleService service;
    @Qualifier("defaultMapper")
    private  final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SaleDTO>>  readAll() throws Exception{
        List<SaleDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleDTO> readById(@PathVariable("id") Integer id) throws Exception{
        SaleDTO obj = convertToDto(service.readById(id));
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SaleDTO> create(@Valid @RequestBody SaleDTO dto) throws Exception{
        Sale obj = service.save(convertToEntity(dto));
        return  new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> update(@Valid  @RequestBody SaleDTO dto, @PathVariable("id") Integer id) throws Exception{
        Sale obj =  service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //////////////////queries//////////////////////////
    @GetMapping(value = "/resume")
    public ResponseEntity<List<ProcedureDTO>> getSaleResume(){
        return  new ResponseEntity<>(service.callProcedure(), HttpStatus.OK);
    }

    @GetMapping(value = "/resume2")
    public ResponseEntity<List<IProcedureDto>> getSaleResume2(){
        return  new ResponseEntity<>(service.callProcedure2(), HttpStatus.OK);
    }
    @GetMapping(value = "/resume3")
    public ResponseEntity<List<ProcedureDTO>> getSaleResume3(){
        return  new ResponseEntity<>(service.callProcedure3(), HttpStatus.OK);
    }
    @GetMapping(value = "/resume4")
    public ResponseEntity<Void> getSaleResume4(){
        service.callProcedure4();
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/mostExpensive")
    public ResponseEntity<SaleDTO> getMostExpensive(){
        SaleDTO dto = convertToDto(service.getSaleMostExpensive());
        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/bestSeller")
    public ResponseEntity<String> getBestSeller(){
        String user = service.getBestSellerPerson();
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/Sellercount")
    public ResponseEntity<Map<String, Long>> getSellerCount(){
        Map<String, Long> byUser = service.getSalesCountBySeller();
        return  new ResponseEntity<>(byUser, HttpStatus.OK);
    }
    @GetMapping(value = "/bestproduct")
    public ResponseEntity<Map<String, Double>> getBestProduct(){
        Map<String, Double> byUser = service.getMostSellerProduct();
        return  new ResponseEntity<>(byUser, HttpStatus.OK);
    }





    private SaleDTO convertToDto(Sale obj){
        return mapper.map(obj,SaleDTO.class);
    }

    private Sale convertToEntity(SaleDTO dto){
        return mapper.map(dto,Sale.class);
    }

}
