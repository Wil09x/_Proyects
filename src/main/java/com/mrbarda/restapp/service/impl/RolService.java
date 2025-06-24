package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Rol;
import com.mrbarda.restapp.repo.IRolRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolService extends GenericService<Rol, Integer> implements IRolService {

    private final IRolRepo repo;

    @Override
    protected IGenericRepo<Rol, Integer> getRepo() {
        return repo;
    }
}
