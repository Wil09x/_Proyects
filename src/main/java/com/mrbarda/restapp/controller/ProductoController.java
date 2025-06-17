package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ProductoDTO;
import com.mrbarda.restapp.model.Producto;
import com.mrbarda.restapp.service.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@Valid @RequestBody ProductoDTO dto) throws Exception {
        Producto producto = modelMapper.map(dto, Producto.class);
        Producto saved = productoService.save(producto);
        return ResponseEntity.ok(modelMapper.map(saved, ProductoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Integer id, @Valid @RequestBody ProductoDTO dto) throws Exception {
        Producto producto = modelMapper.map(dto, Producto.class);
        Producto updated = productoService.update(producto, id);
        return ResponseEntity.ok(modelMapper.map(updated, ProductoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll() throws Exception {
        List<ProductoDTO> list = productoService.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProductoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Integer id) throws Exception {
        Producto platillo = productoService.findById(id);
        return ResponseEntity.ok(modelMapper.map(platillo, ProductoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
