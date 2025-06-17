package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.model.Notificacion;
import com.mrbarda.restapp.repo.INotificacionRepo;
import com.mrbarda.restapp.repo.IGenericRepo;
import com.mrbarda.restapp.service.INotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacionService extends GenericService<Notificacion, Integer> implements INotificacionService {
    private final INotificacionRepo repo;

    @Override
    protected IGenericRepo<Notificacion, Integer> getRepo() {
        return repo;
    }
}

