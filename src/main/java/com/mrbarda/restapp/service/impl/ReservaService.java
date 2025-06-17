package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Reserva;
import com.mrbarda.restapp.repo.IReservaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService extends GenericService<Reserva, Integer> implements IReservaService {

    private final IReservaRepo repo;

    @Override
    protected IGenericRepo<Reserva, Integer> getRepo() {
        return repo;
    }
}


