package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.InventarioDTO;
import com.mrbarda.restapp.model.Inventario;
import com.mrbarda.restapp.service.IInventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class InventarioController {

    private final IInventarioService inventarioService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<InventarioDTO> save(@Valid @RequestBody InventarioDTO dto) throws Exception {
        Inventario entity = modelMapper.map(dto, Inventario.class);
        Inventario saved = inventarioService.save(entity);
        return ResponseEntity.ok(modelMapper.map(saved, InventarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> update(@PathVariable Integer id, @Valid @RequestBody InventarioDTO dto) throws Exception {
        Inventario entity = modelMapper.map(dto, Inventario.class);
        Inventario updated = inventarioService.update(entity, id);
        return ResponseEntity.ok(modelMapper.map(updated, InventarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> findAll() throws Exception {
        List<InventarioDTO> list = inventarioService.findAll()
                .stream()
                .map(inv -> modelMapper.map(inv, InventarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> findById(@PathVariable Integer id) throws Exception {
        Inventario entity = inventarioService.findById(id);
        return ResponseEntity.ok(modelMapper.map(entity, InventarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        inventarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
