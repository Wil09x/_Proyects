package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.NotificacionDTO;
import com.mrbarda.restapp.model.Notificacion;
import com.mrbarda.restapp.service.INotificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class NotificacionController {

    private final INotificacionService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<NotificacionDTO> save(@Valid @RequestBody NotificacionDTO dto) throws Exception {
        Notificacion noti = modelMapper.map(dto, Notificacion.class);
        Notificacion saved = service.save(noti);
        return ResponseEntity.ok(modelMapper.map(saved, NotificacionDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDTO> update(@PathVariable Integer id, @Valid @RequestBody NotificacionDTO dto) throws Exception {
        Notificacion noti = modelMapper.map(dto, Notificacion.class);
        Notificacion updated = service.update(noti, id);
        return ResponseEntity.ok(modelMapper.map(updated, NotificacionDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> findAll() throws Exception {
        List<NotificacionDTO> list = service.findAll()
                .stream()
                .map(n -> modelMapper.map(n, NotificacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> findById(@PathVariable Integer id) throws Exception {
        Notificacion noti = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(noti, NotificacionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
