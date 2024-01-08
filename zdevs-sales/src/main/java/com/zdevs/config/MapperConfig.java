package com.zdevs.config;


import com.zdevs.dto.CategoryDTO;
import com.zdevs.dto.ProductDTO;
import com.zdevs.model.Category;
import com.zdevs.model.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("categoryMapper")
    public ModelMapper modelMapper(){

        ModelMapper mapper = new ModelMapper();

        //lectura de Datos
        TypeMap<Category, CategoryDTO> typeMap1 = mapper.createTypeMap(Category.class,CategoryDTO.class);
        typeMap1.addMapping(Category::getName, (dest, v) -> dest.setNameOfCategory((String) v));

        //escritura de datos
        TypeMap<CategoryDTO, Category> typeMap2 = mapper.createTypeMap(CategoryDTO.class,Category.class);
        typeMap2.addMapping(CategoryDTO::getNameOfCategory, (dest, v) -> dest.setName((String) v));

        return  mapper;
    }
    @Bean("productMapper")
    public ModelMapper productMapper(){

        ModelMapper mapper = new ModelMapper();


        TypeMap<Product, ProductDTO> typeMap1 = mapper.createTypeMap(Product.class,ProductDTO.class);
        typeMap1.addMapping(e -> e.getCategory().getIdCategory(), (dest, v) -> dest.setIdOfCategory((Integer) v));

        TypeMap<ProductDTO, Product> typeMap2 = mapper.createTypeMap(ProductDTO.class,Product.class);
        typeMap2.addMapping(ProductDTO::getIdOfCategory, (dest, v) -> dest.getCategory().setIdCategory((Integer) v));


        return  mapper;
    }



    @Bean("defaultMapper")
    public  ModelMapper defaultMapper(){
        return  new ModelMapper();
    }

}
