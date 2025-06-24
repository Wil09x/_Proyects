package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.ConfiguracionEmpresa;
import com.mrbarda.restapp.repo.IConfiguracionEmpresaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IConfiguracionEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfiguracionEmpresaService extends GenericService<ConfiguracionEmpresa, Integer> implements IConfiguracionEmpresaService {

    private final IConfiguracionEmpresaRepo repo;

    @Override
    protected IGenericRepo<ConfiguracionEmpresa, Integer> getRepo() {
        return repo;
    }
}
