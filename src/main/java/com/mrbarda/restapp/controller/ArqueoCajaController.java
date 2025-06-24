package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ArqueoCajaDTO;
import com.mrbarda.restapp.service.IArqueoCajaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arqueos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ArqueoCajaController {

    private final IArqueoCajaService service;

    @PostMapping
    public ResponseEntity<ArqueoCajaDTO> save(@Valid @RequestBody ArqueoCajaDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<ArqueoCajaDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> update(@PathVariable Integer id, @Valid @RequestBody ArqueoCajaDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

