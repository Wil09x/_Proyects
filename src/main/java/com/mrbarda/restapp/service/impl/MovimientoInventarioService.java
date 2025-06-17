package com.mrbarda.restapp.service.impl;


import com.mrbarda.restapp.model.MovimientoInventario;
import com.mrbarda.restapp.repo.IMovimientoInventarioRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IMovimientoInventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovimientoInventarioService extends GenericService<MovimientoInventario, Integer> implements IMovimientoInventarioService {

    private final IMovimientoInventarioRepo repo;

    @Override
    protected IGenericRepo<MovimientoInventario, Integer> getRepo() {
        return repo;
    }
}

