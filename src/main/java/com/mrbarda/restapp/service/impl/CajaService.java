package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Caja;
import com.mrbarda.restapp.repo.ICajaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.ICajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CajaService extends GenericService<Caja, Integer> implements ICajaService {
    private final ICajaRepo repo;

    @Override
    protected IGenericRepo<Caja, Integer> getRepo() {
        return repo;
    }
}

