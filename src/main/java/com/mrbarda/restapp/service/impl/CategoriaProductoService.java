package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.CategoriaProducto;
import com.mrbarda.restapp.repo.ICategoriaProductoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.ICategoriaProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaProductoService extends GenericService<CategoriaProducto, Integer> implements ICategoriaProductoService {
    private final ICategoriaProductoRepo repo;

    @Override
    protected IGenericRepo<CategoriaProducto, Integer> getRepo() {
        return repo;
    }
}

