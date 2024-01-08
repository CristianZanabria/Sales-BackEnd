package com.zdevs.controller;

import com.zdevs.dto.UserDTO;
import com.zdevs.model.User;
import com.zdevs.service.IUserService;
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
@RequestMapping("/users")
public class UserController {


    //@Autowired
    private final IUserService service;
    @Qualifier("defaultMapper")
    private  final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>>  readAll() throws Exception{
        List<UserDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> readById(@PathVariable("id") Integer id) throws Exception{
        UserDTO obj = convertToDto(service.readById(id));
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO dto) throws Exception{
        User obj = service.save(convertToEntity(dto));
        return  new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@Valid  @RequestBody UserDTO dto, @PathVariable("id") Integer id) throws Exception{
        User obj =  service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private UserDTO convertToDto(User obj){
        return mapper.map(obj,UserDTO.class);
    }

    private User convertToEntity(UserDTO dto){
        return mapper.map(dto,User.class);
    }



}
