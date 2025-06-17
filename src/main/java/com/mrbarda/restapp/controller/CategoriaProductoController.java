package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.CategoriaProductoDTO;
import com.mrbarda.restapp.model.CategoriaProducto;
import com.mrbarda.restapp.service.ICategoriaProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias-producto")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CategoriaProductoController {

    private final ICategoriaProductoService categoriaProductoService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CategoriaProductoDTO> save(@Valid @RequestBody CategoriaProductoDTO dto) throws Exception {
        CategoriaProducto categoria = modelMapper.map(dto, CategoriaProducto.class);
        CategoriaProducto saved = categoriaProductoService.save(categoria);
        return ResponseEntity.ok(modelMapper.map(saved, CategoriaProductoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> update(@PathVariable Integer id, @Valid @RequestBody CategoriaProductoDTO dto) throws Exception {
        CategoriaProducto categoria = modelMapper.map(dto, CategoriaProducto.class);
        CategoriaProducto updated = categoriaProductoService.update(categoria, id);
        return ResponseEntity.ok(modelMapper.map(updated, CategoriaProductoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProductoDTO>> findAll() throws Exception {
        List<CategoriaProductoDTO> list = categoriaProductoService.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CategoriaProductoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> findById(@PathVariable Integer id) throws Exception {
        CategoriaProducto categoria = categoriaProductoService.findById(id);
        return ResponseEntity.ok(modelMapper.map(categoria, CategoriaProductoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        categoriaProductoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
