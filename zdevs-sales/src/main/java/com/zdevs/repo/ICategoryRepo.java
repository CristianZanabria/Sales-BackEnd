package com.zdevs.repo;

import com.zdevs.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepo extends IGenericRepo<Category, Integer> {
    //derivedQueries

    // select *from Category c  where c.name = '';
    // select *from Category c  where c.name  like '%abc%';
    List<Category> findByName(String name);
    List<Category> findByNameLike(String name);

    //%XYZ% -> findByNameContains
    //%XYZ -> findByNameStarsWith
    //XYZ% -> findByNameEndWith
    List<Category> findByNameAndEnabled(String name, boolean enabled);
    List<Category> findByNameOrEnabled(String name, boolean enabled);

    List<Category> findByEnabledTrue();
    List<Category> findByEnabledFalse();

    Category findOneByName(String name);
    List<Category> findTop5ByName(String name);
    List<Category> findByNameIs(String name);
    List<Category> findByNameIsNot(String name);

    List<Category> findByNameIsNull();
    List<Category> findByNameIsNotNull();
    List<Category> findByNameEqualsIgnoreCase(String name);

    List<Category> findByIdCategoryLessThan(Integer id);
    List<Category> findByIdCategoryLessThanEqual(Integer id);
    List<Category> findByIdCategoryGreaterThan(Integer id);
    List<Category> findByIdCategoryGreaterThanEqual(Integer id);

    List<Category> findByIdCategoryBetween(Integer id, Integer id1);
    List<Category> findByNameOrderByDescription(String name);
    List<Category> findByNameOrderByDescriptionAsc(String name);
    List<Category> findByNameOrderByDescriptionDesc(String name);

    //JPQL : Java Persistence Query Language

    @Query("FROM Category  c WHERE c.name =:name AND c.description LIKE %:description%")
    List<Category> getNameAndDescription1(@Param("name") String name, @Param("description") String description);
    @Query("SELECT new Category(c.name, c.description) FROM Category  c WHERE c.name =:name AND c.description LIKE %:description%")
    List<Category> getNameAndDescription2(@Param("name") String name, @Param("description") String description);

    //sql NativeQuery

    @Query(value = "SELECT c.id_category, c.name,c.description, c.enabled from category c where c.name =:name",nativeQuery = true)
    List<Category> getNameSql(@Param("name") String name);

    @Modifying
    @Query(value = "UPDATE category set name = :name", nativeQuery = true)
    Integer updateNames(@Param("name") String name);





}






















