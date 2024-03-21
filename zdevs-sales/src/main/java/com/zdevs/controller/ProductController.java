package com.zdevs.controller;

import com.zdevs.dto.CategoryDTO;
import com.zdevs.dto.ProductDTO;
import com.zdevs.model.Product;
import com.zdevs.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {


    //@Autowired
    private final IProductService service;
    @Qualifier("productMapper")
    private  final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>>  readAll() throws Exception{
        List<ProductDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> readById(@PathVariable("id") Integer id) throws Exception{
        ProductDTO obj = convertToDto(service.readById(id));
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) throws Exception{
        Product obj = service.save(convertToEntity(dto));
        return  new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@Valid  @RequestBody ProductDTO dto, @PathVariable("id") Integer id) throws Exception{
        Product obj =  service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<ProductDTO>> findPage(Pageable pageable) throws Exception{
        Page<ProductDTO> pageProduct = service.getPage(pageable).map(this::convertToDto);
        return new ResponseEntity<>(pageProduct, HttpStatus.OK);
    }

    private ProductDTO convertToDto(Product obj){
        return mapper.map(obj,ProductDTO.class);
    }

    private Product convertToEntity(ProductDTO dto){
        return mapper.map(dto,Product.class);
    }



}
