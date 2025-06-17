package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.DescuentoPromocion;
import com.mrbarda.restapp.repo.IDescuentoPromocionRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IDescuentoPromocionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DescuentoPromocionService extends GenericService<DescuentoPromocion, Integer> implements IDescuentoPromocionService {
    private final IDescuentoPromocionRepo repo;

    @Override
    protected IGenericRepo<DescuentoPromocion, Integer> getRepo() {
        return repo;
    }
}
