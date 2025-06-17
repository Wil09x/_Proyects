package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.DescuentoPromocionDTO;
import com.mrbarda.restapp.model.DescuentoPromocion;
import com.mrbarda.restapp.service.IDescuentoPromocionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descuentos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class DescuentoPromocionController {

    private final IDescuentoPromocionService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DescuentoPromocionDTO> save(@Valid @RequestBody DescuentoPromocionDTO dto) throws Exception {
        DescuentoPromocion entity = modelMapper.map(dto, DescuentoPromocion.class);
        DescuentoPromocion saved = service.save(entity);
        return ResponseEntity.ok(modelMapper.map(saved, DescuentoPromocionDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescuentoPromocionDTO> update(@PathVariable Integer id, @Valid @RequestBody DescuentoPromocionDTO dto) throws Exception {
        DescuentoPromocion entity = modelMapper.map(dto, DescuentoPromocion.class);
        DescuentoPromocion updated = service.update(entity, id);
        return ResponseEntity.ok(modelMapper.map(updated, DescuentoPromocionDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<DescuentoPromocionDTO>> findAll() throws Exception {
        List<DescuentoPromocionDTO> list = service.findAll()
                .stream()
                .map(d -> modelMapper.map(d, DescuentoPromocionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescuentoPromocionDTO> findById(@PathVariable Integer id) throws Exception {
        DescuentoPromocion entity = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(entity, DescuentoPromocionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
