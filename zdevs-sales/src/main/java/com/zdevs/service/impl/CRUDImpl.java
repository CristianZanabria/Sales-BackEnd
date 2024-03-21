package com.zdevs.service.impl;

import com.zdevs.exception.ModelNotFoundException;
import com.zdevs.repo.IGenericRepo;
import com.zdevs.service.ICRUD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {
    protected abstract IGenericRepo<T,ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);

    }

    @Override
    public Page<T> getPage(Pageable pageable) throws Exception {
        return getRepo().findAll(pageable);
    }
}
