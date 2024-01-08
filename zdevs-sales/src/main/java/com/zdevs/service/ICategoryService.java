package com.zdevs.service;

import com.zdevs.model.Category;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryService extends ICRUD<Category, Integer> {
    List<Category> findByName(String name);
    List<Category> findByNameLike(String name);
    List<Category> findByNameAndEnabled(String name, boolean enabled);
    List<Category> getNameAndDescription1( String name,  String description);
    List<Category> getNameAndDescription2( String name,  String description);
    List<Category> getNameSql(@Param("name") String name);

}
