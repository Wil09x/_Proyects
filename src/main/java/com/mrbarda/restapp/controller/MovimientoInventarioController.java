package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.MovimientoInventarioDTO;
import com.mrbarda.restapp.model.MovimientoInventario;
import com.mrbarda.restapp.service.IMovimientoInventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movimientos-inventario")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MovimientoInventarioController {

    private final IMovimientoInventarioService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<MovimientoInventarioDTO> save(@Valid @RequestBody MovimientoInventarioDTO dto) throws Exception {
        MovimientoInventario entity = modelMapper.map(dto, MovimientoInventario.class);
        MovimientoInventario saved = service.save(entity);
        return ResponseEntity.ok(modelMapper.map(saved, MovimientoInventarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoInventarioDTO> update(@PathVariable Integer id, @Valid @RequestBody MovimientoInventarioDTO dto) throws Exception {
        MovimientoInventario entity = modelMapper.map(dto, MovimientoInventario.class);
        MovimientoInventario updated = service.update(entity, id);
        return ResponseEntity.ok(modelMapper.map(updated, MovimientoInventarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<MovimientoInventarioDTO>> findAll() throws Exception {
        List<MovimientoInventarioDTO> list = service.findAll()
                .stream()
                .map(m -> modelMapper.map(m, MovimientoInventarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventarioDTO> findById(@PathVariable Integer id) throws Exception {
        MovimientoInventario entity = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(entity, MovimientoInventarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
