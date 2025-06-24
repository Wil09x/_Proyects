package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.ArqueoCaja;
import com.mrbarda.restapp.repo.IArqueoCajaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IArqueoCajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArqueoCajaService extends GenericService<ArqueoCaja, Integer> implements IArqueoCajaService {

    private final IArqueoCajaRepo repo;

    @Override
    protected IGenericRepo<ArqueoCaja, Integer> getRepo() {
        return repo;
    }
}
