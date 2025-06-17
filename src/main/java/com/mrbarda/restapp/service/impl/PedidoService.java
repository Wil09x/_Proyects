package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Pedido;
import com.mrbarda.restapp.repo.IPedidoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService extends GenericService<Pedido, Integer> implements IPedidoService {
    private final IPedidoRepo repo;

    @Override
    protected IGenericRepo<Pedido, Integer> getRepo() {
        return repo;
    }
}

