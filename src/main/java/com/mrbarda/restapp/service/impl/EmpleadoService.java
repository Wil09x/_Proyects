package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Empleado;
import com.mrbarda.restapp.repo.IEmpleadoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoService extends GenericService<Empleado, Integer> implements IEmpleadoService {
    private final IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleado, Integer> getRepo() {
        return repo;
    }
}

