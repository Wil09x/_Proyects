package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Bitacora;
import com.mrbarda.restapp.repo.IBitacoraRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IBitacoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BitacoraService extends GenericService<Bitacora, Integer> implements IBitacoraService {

    private final IBitacoraRepo repo;

    @Override
    protected IGenericRepo<Bitacora, Integer> getRepo() {
        return repo;
    }
}
