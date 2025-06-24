package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.SesionUsuarioDTO;
import com.mrbarda.restapp.service.ISesionUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesiones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SesionUsuarioController {

    private final ISesionUsuarioService service;

    @PostMapping
    public ResponseEntity<SesionUsuarioDTO> save(@Valid @RequestBody SesionUsuarioDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<SesionUsuarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody SesionUsuarioDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

