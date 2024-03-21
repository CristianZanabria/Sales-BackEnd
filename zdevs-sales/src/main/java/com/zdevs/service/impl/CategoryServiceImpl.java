package com.zdevs.service.impl;

import com.zdevs.model.Category;
import com.zdevs.repo.ICategoryRepo;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {

    //@Autowired
    private final ICategoryRepo repo; //= new CategoryRepository();

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Category> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Category> findByNameLike(String name) {
        return repo.findByNameLike("%" + name +"%");
    }

    @Override
    public List<Category> findByNameAndEnabled(String name, boolean enabled) {
        return repo.findByNameAndEnabled(name, enabled);
    }

    @Override
    public List<Category> getNameAndDescription1(String name, String description) {
        return repo.getNameAndDescription1(name, description);
    }
    @Override
    public List<Category> getNameAndDescription2(String name, String description) {
        return repo.getNameAndDescription2(name, description);
    }

    @Override
    public List<Category> getNameSql(String name) {
        return repo.getNameSql(name);
    }

    @Override
    public Page<Category> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<Category> findAllOrder(String param) {
        Sort.Direction direction = param.equalsIgnoreCase("ASC")? Sort.Direction.ASC : Sort.Direction.DESC;
        return repo.findAll(Sort.by(direction, "name"));
    }


   /* public Category saveAndValid(Category category) {
        if (category.getIdCategory() > 0) {
            System.out.println("Category ID is the DB");
            return null;
        } else {
            return repository.save(category);
        }
    }*/
}
