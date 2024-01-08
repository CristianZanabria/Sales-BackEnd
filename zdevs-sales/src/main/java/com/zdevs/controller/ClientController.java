package com.zdevs.controller;

import com.zdevs.dto.ClientDTO;
import com.zdevs.model.Client;
import com.zdevs.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {


    //@Autowired
    private final IClientService service;
    @Qualifier("defaultMapper")
    private  final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>>  readAll() throws Exception{
        List<ClientDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> readById(@PathVariable("id") Integer id) throws Exception{
        ClientDTO obj = convertToDto(service.readById(id));
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto) throws Exception{
        Client obj = service.save(convertToEntity(dto));
        return  new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid  @RequestBody ClientDTO dto, @PathVariable("id") Integer id) throws Exception{
        Client obj =  service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ClientDTO convertToDto(Client obj){
        return mapper.map(obj,ClientDTO.class);
    }

    private Client convertToEntity(ClientDTO dto){
        return mapper.map(dto,Client.class);
    }



}
