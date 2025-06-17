package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.SatisfaccionDTO;
import com.mrbarda.restapp.model.Satisfaccion;
import com.mrbarda.restapp.service.ISatisfaccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/satisfacciones")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class SatisfaccionController {

    private final ISatisfaccionService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SatisfaccionDTO> save(@Valid @RequestBody SatisfaccionDTO dto) throws Exception {
        Satisfaccion entity = modelMapper.map(dto, Satisfaccion.class);
        Satisfaccion saved = service.save(entity);
        return ResponseEntity.ok(modelMapper.map(saved, SatisfaccionDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatisfaccionDTO> update(@PathVariable Integer id, @Valid @RequestBody SatisfaccionDTO dto) throws Exception {
        Satisfaccion entity = modelMapper.map(dto, Satisfaccion.class);
        Satisfaccion updated = service.update(entity, id);
        return ResponseEntity.ok(modelMapper.map(updated, SatisfaccionDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<SatisfaccionDTO>> findAll() throws Exception {
        List<SatisfaccionDTO> list = service.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SatisfaccionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SatisfaccionDTO> findById(@PathVariable Integer id) throws Exception {
        Satisfaccion entity = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(entity, SatisfaccionDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
