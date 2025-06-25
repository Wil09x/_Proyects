package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ArqueoCajaDTO;
import com.mrbarda.restapp.model.ArqueoCaja;
import com.mrbarda.restapp.service.IArqueoCajaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arqueos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ArqueoCajaController {

    private final IArqueoCajaService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ArqueoCajaDTO> save(@Valid @RequestBody ArqueoCajaDTO dto) throws Exception {
        ArqueoCaja entity = mapper.map(dto, ArqueoCaja.class);
        ArqueoCaja saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, ArqueoCajaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> update(@PathVariable Integer id, @Valid @RequestBody ArqueoCajaDTO dto) throws Exception {
        ArqueoCaja entity = mapper.map(dto, ArqueoCaja.class);
        ArqueoCaja updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, ArqueoCajaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ArqueoCajaDTO>> findAll() throws Exception {
        List<ArqueoCajaDTO> list = service.findAll()
                .stream()
                .map(e -> mapper.map(e, ArqueoCajaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> findById(@PathVariable Integer id) throws Exception {
        ArqueoCaja entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, ArqueoCajaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
