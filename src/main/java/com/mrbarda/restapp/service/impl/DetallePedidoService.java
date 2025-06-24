package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.DetallePedido;
import com.mrbarda.restapp.repo.IDetallePedidoRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.IDetallePedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetallePedidoService extends GenericService<DetallePedido, Integer> implements IDetallePedidoService {

    private final IDetallePedidoRepo repo;

    @Override
    protected IGenericRepo<DetallePedido, Integer> getRepo() {
        return repo;
    }
}
