package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.IngredienteProducto;
import com.mrbarda.restapp.repo.IIngredienteProductoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IIngredienteProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredienteProductoService extends GenericService<IngredienteProducto, Integer> implements IIngredienteProductoService {

    private final IIngredienteProductoRepo repo;

    @Override
    protected IGenericRepo<IngredienteProducto, Integer> getRepo() {
        return repo;
    }
}
