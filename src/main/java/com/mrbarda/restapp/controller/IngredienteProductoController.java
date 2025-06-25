package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.IngredienteProductoDTO;
import com.mrbarda.restapp.model.IngredienteProducto;
import com.mrbarda.restapp.service.IIngredienteProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes-producto")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IngredienteProductoController {

    private final IIngredienteProductoService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<IngredienteProductoDTO> save(@Valid @RequestBody IngredienteProductoDTO dto) throws Exception {
        IngredienteProducto entity = mapper.map(dto, IngredienteProducto.class);
        IngredienteProducto saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, IngredienteProductoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredienteProductoDTO> update(@PathVariable Integer id, @Valid @RequestBody IngredienteProductoDTO dto) throws Exception {
        IngredienteProducto entity = mapper.map(dto, IngredienteProducto.class);
        IngredienteProducto updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, IngredienteProductoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<IngredienteProductoDTO>> findAll() throws Exception {
        List<IngredienteProductoDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, IngredienteProductoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteProductoDTO> findById(@PathVariable Integer id) throws Exception {
        IngredienteProducto entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, IngredienteProductoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
