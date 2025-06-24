package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Mesa;
import com.mrbarda.restapp.repo.IMesaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IMesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MesaService extends GenericService<Mesa, Integer> implements IMesaService {

    private final IMesaRepo repo;

    @Override
    protected IGenericRepo<Mesa, Integer> getRepo() {
        return repo;
    }
}
