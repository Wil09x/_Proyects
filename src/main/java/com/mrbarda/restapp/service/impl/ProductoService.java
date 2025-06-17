package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Producto;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.repo.IProductoRepo;
import com.mrbarda.restapp.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService extends GenericService<Producto, Integer> implements IProductoService {
    private final IProductoRepo repo;

    @Override
    protected IGenericRepo<Producto, Integer> getRepo() {
        return repo;
    }
}

