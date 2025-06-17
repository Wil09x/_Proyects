package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Factura;
import com.mrbarda.restapp.repo.IFacturaRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IFacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacturaService extends GenericService<Factura, Integer> implements IFacturaService {
    private final IFacturaRepo repo;

    @Override
    protected IGenericRepo<Factura, Integer> getRepo() {
        return repo;
    }
}
