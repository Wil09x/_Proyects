package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.TurnoEmpleado;
import com.mrbarda.restapp.repo.ITurnoEmpleadoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.ITurnoEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TurnoEmpleadoService extends GenericService<TurnoEmpleado, Integer> implements ITurnoEmpleadoService {
    private final ITurnoEmpleadoRepo repo;

    @Override
    protected IGenericRepo<TurnoEmpleado, Integer> getRepo() {
        return repo;
    }
}

