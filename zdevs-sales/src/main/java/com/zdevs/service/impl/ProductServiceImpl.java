package com.zdevs.service.impl;

import com.zdevs.model.Product;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.repo.IProductRepo;
import com.zdevs.service.IProductService;
import com.zdevs.service.impl.CRUDImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {

    private final IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return repo;
    }
}
