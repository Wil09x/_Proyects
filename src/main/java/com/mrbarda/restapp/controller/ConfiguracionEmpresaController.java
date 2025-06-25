package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ConfiguracionEmpresaDTO;
import com.mrbarda.restapp.model.ConfiguracionEmpresa;
import com.mrbarda.restapp.service.IConfiguracionEmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/configuracion")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ConfiguracionEmpresaController {

    private final IConfiguracionEmpresaService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ConfiguracionEmpresaDTO> save(@Valid @RequestBody ConfiguracionEmpresaDTO dto) throws Exception {
        ConfiguracionEmpresa entity = mapper.map(dto, ConfiguracionEmpresa.class);
        ConfiguracionEmpresa saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, ConfiguracionEmpresaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaDTO> update(@PathVariable Integer id, @Valid @RequestBody ConfiguracionEmpresaDTO dto) throws Exception {
        ConfiguracionEmpresa entity = mapper.map(dto, ConfiguracionEmpresa.class);
        ConfiguracionEmpresa updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, ConfiguracionEmpresaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ConfiguracionEmpresaDTO>> findAll() throws Exception {
        List<ConfiguracionEmpresaDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, ConfiguracionEmpresaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaDTO> findById(@PathVariable Integer id) throws Exception {
        ConfiguracionEmpresa entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, ConfiguracionEmpresaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
