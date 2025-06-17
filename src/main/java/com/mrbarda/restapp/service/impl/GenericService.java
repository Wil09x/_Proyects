package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.exception.ModelNotFoundException;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IGenericService;

import java.util.List;

public abstract class GenericService<T, ID> implements IGenericService<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}

