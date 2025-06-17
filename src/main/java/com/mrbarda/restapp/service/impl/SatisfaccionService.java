package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Satisfaccion;
import com.mrbarda.restapp.repo.ISatisfaccionRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.ISatisfaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatisfaccionService extends GenericService<Satisfaccion, Integer> implements ISatisfaccionService {
    private final ISatisfaccionRepo repo;

    @Override
    protected IGenericRepo<Satisfaccion, Integer> getRepo() {
        return repo;
    }
}

