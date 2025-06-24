package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.BitacoraDTO;
import com.mrbarda.restapp.service.IBitacoraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitacoras")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BitacoraController {

    private final IBitacoraService service;

    @PostMapping
    public ResponseEntity<BitacoraDTO> save(@Valid @RequestBody BitacoraDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<BitacoraDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BitacoraDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BitacoraDTO> update(@PathVariable Integer id, @Valid @RequestBody BitacoraDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

