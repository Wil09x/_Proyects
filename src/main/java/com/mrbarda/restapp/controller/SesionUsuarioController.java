package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.SesionUsuarioDTO;
import com.mrbarda.restapp.model.SesionUsuario;
import com.mrbarda.restapp.service.ISesionUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sesiones")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SesionUsuarioController {

    private final ISesionUsuarioService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<SesionUsuarioDTO> save(@Valid @RequestBody SesionUsuarioDTO dto) throws Exception {
        SesionUsuario entity = mapper.map(dto, SesionUsuario.class);
        SesionUsuario saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, SesionUsuarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody SesionUsuarioDTO dto) throws Exception {
        SesionUsuario entity = mapper.map(dto, SesionUsuario.class);
        SesionUsuario updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, SesionUsuarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<SesionUsuarioDTO>> findAll() throws Exception {
        List<SesionUsuarioDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, SesionUsuarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> findById(@PathVariable Integer id) throws Exception {
        SesionUsuario entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, SesionUsuarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
