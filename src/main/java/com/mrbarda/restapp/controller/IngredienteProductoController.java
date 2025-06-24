package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.IngredienteProductoDTO;
import com.mrbarda.restapp.service.IIngredienteProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes-producto")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class IngredienteProductoController {

    private final IIngredienteProductoService service;

    @PostMapping
    public ResponseEntity<IngredienteProductoDTO> save(@Valid @RequestBody IngredienteProductoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<IngredienteProductoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteProductoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredienteProductoDTO> update(@PathVariable Integer id, @Valid @RequestBody IngredienteProductoDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

