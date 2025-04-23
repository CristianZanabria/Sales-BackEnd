package com.zdevs.service;

import com.zdevs.dto.CategoryDTO;
import com.zdevs.model.Category;
import com.zdevs.repo.ICategoryRepo;
import com.zdevs.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockBean
    private CategoryServiceImpl service;

    @MockBean
    private ICategoryRepo repo;


    private Category CATEGORY_1;
    private Category CATEGORY_2;
    private Category CATEGORY_3;

    @BeforeEach
    public  void init(){
        MockitoAnnotations.openMocks(this);
        this.service = new CategoryServiceImpl(repo);

        CATEGORY_1 = new Category(1,"tv","Television",true);
        CATEGORY_2 = new Category(2,"PSP","Play Station Portable",true);
        CATEGORY_3 = new Category(3,"BOOkS","Some Books",true);

        List<Category> categories = List.of( CATEGORY_1, CATEGORY_2,CATEGORY_3);
        Mockito.when(repo.findAll()).thenReturn(categories);
        Mockito.when(repo.findById(any())).thenReturn(Optional.of(CATEGORY_1));
        Mockito.when(repo.save(any())).thenReturn(CATEGORY_1);


    }
    @Test
    void readAllTest() throws  Exception{

        List<Category> response = service.readAll();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(response.size(),3);
    }
    @Test
    void readById() throws  Exception{
        final  int ID = 1;

        Category response = service.readById(ID);

        assertNotNull(response);

    }
    @Test
    void save() throws Exception{
        Category response = service.save(CATEGORY_1);

        assertNotNull(response);
    }
    @Test
    void update() throws Exception{
        Category response = service.update(CATEGORY_1, any());

        assertNotNull(response);
    }
    @Test
    void delete() throws  Exception{
        final int ID = 1;
        repo.deleteById(1);

        verify(repo, times(1)).deleteById(ID);
    }



}
