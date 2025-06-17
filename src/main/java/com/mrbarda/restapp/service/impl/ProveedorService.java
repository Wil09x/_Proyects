package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Proveedor;
import com.mrbarda.restapp.repo.IProveedorRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProveedorService extends GenericService<Proveedor, Integer> implements IProveedorService {
    private final IProveedorRepo repo;

    @Override
    protected IGenericRepo<Proveedor, Integer> getRepo() {
        return repo;
    }
}

