package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ConfiguracionEmpresaDTO;
import com.mrbarda.restapp.service.IConfiguracionEmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ConfiguracionEmpresaController {

    private final IConfiguracionEmpresaService service;

    @PostMapping
    public ResponseEntity<ConfiguracionEmpresaDTO> save(@Valid @RequestBody ConfiguracionEmpresaDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ConfiguracionEmpresaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaDTO> update(@PathVariable Integer id, @Valid @RequestBody ConfiguracionEmpresaDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

