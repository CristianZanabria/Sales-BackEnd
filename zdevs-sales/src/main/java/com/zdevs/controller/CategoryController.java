package com.zdevs.controller;

import com.zdevs.dto.CategoryDTO;
import com.zdevs.model.Category;

import com.zdevs.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {


    //@Autowired
    private final ICategoryService service; //= new CategoryService();
    @Qualifier("categoryMapper")
    private  final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>>  readAll() throws Exception{
        //ModelMapper mapper = new ModelMapper();
        List<CategoryDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable("id") Integer id) throws Exception{
        CategoryDTO obj = convertToDto(service.readById(id));
        return  new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO dto) throws Exception{
        Category obj = service.save(convertToEntity(dto));
        return  new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid  @RequestBody CategoryDTO dto, @PathVariable("id") Integer id) throws Exception{
        Category obj =  service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id") Integer id) throws Exception{
         service.delete(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /////////////////queries///////////////////////////////////////

    @GetMapping("find/name/{name}")
    public  ResponseEntity<List<CategoryDTO>> findByName(@PathVariable("name") String name){
        List<CategoryDTO> list = service.findByName(name).stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("find/name/like/{name}")
    public  ResponseEntity<List<CategoryDTO>> findByNameLike(@PathVariable("name") String name){
        List<CategoryDTO> list = service.findByNameLike(name).stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("find/name/enabled/{name}/{enabled}")
    public  ResponseEntity<List<CategoryDTO>> findByNameAndEnabled(@PathVariable("name") String name,@PathVariable("enabled") boolean enabled){
        List<CategoryDTO> list = service.findByNameAndEnabled(name, enabled).stream().map(this::convertToDto).toList();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    /*@GetMapping("/get/name/description")
    public ResponseEntity<List<CategoryDTO>> getNameAndDescription(@RequestParam("name") String name, @RequestParam("description") String description){
        List<CategoryDTO> lst = service.getNameAndDescription1(name, description).stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }*/
    @GetMapping("/get/name/description")
    public ResponseEntity<List<CategoryDTO>> getNameAndDescriptions(@RequestParam("name") String name, @RequestParam("description") String description){
        List<CategoryDTO> lst = service.getNameAndDescription2(name, description).stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }
    @GetMapping("/get/name/sql/{name}")
    public ResponseEntity<List<CategoryDTO>> getNameSQL(@PathVariable("name") String name){
        List<CategoryDTO> lst = service.getNameSql(name).stream().map(this::convertToDto).toList();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }


    private CategoryDTO convertToDto(Category obj){
        return mapper.map(obj,CategoryDTO.class);
    }

    private Category convertToEntity(CategoryDTO dto){
        return mapper.map(dto,Category.class);
    }



   /* public CategoryController(CategoryService service) {
        this.service = service;
    }*/

    /*@GetMapping
    public String sayHello(){
        return  "Hola Milagros";
    }*/

   /* @GetMapping
    public Category saveCategory(){

        Category category = new Category(1,"PC","treue", true);
        return  service.saveAndValid(category);


    }*/

}
