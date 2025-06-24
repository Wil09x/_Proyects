package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.SesionUsuario;
import com.mrbarda.restapp.repo.ISesionUsuarioRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.ISesionUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesionUsuarioService extends GenericService<SesionUsuario, Integer> implements ISesionUsuarioService {

    private final ISesionUsuarioRepo repo;

    @Override
    protected IGenericRepo<SesionUsuario, Integer> getRepo() {
        return repo;
    }
}
