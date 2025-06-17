package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ProveedorDTO;
import com.mrbarda.restapp.model.Proveedor;
import com.mrbarda.restapp.service.IProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService proveedorService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ProveedorDTO> save(@Valid @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor proveedor = modelMapper.map(dto, Proveedor.class);
        Proveedor saved = proveedorService.save(proveedor);
        return ResponseEntity.ok(modelMapper.map(saved, ProveedorDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable Integer id, @Valid @RequestBody ProveedorDTO dto) throws Exception {
        Proveedor proveedor = modelMapper.map(dto, Proveedor.class);
        Proveedor updated = proveedorService.update(proveedor, id);
        return ResponseEntity.ok(modelMapper.map(updated, ProveedorDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> findAll() throws Exception {
        List<ProveedorDTO> list = proveedorService.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProveedorDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable Integer id) throws Exception {
        Proveedor proveedor = proveedorService.findById(id);
        return ResponseEntity.ok(modelMapper.map(proveedor, ProveedorDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        proveedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
