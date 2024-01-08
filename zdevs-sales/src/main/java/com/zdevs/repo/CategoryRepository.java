package com.zdevs.repo;

import com.zdevs.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

    public Category save (Category category){
        System.out.println(" Saving ...."+ category);
        return  category;
    }
}
