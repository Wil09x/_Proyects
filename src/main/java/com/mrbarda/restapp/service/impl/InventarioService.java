package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Inventario;
import com.mrbarda.restapp.repo.IInventarioRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IInventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventarioService extends GenericService<Inventario, Integer> implements IInventarioService {
    private final IInventarioRepo repo;

    @Override
    protected IGenericRepo<Inventario, Integer> getRepo() {
        return repo;
    }
}

