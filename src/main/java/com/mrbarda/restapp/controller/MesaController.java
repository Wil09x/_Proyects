package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.MesaDTO;
import com.mrbarda.restapp.model.Mesa;
import com.mrbarda.restapp.service.IMesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mesas")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class MesaController {

    private final IMesaService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<MesaDTO> save(@Valid @RequestBody MesaDTO dto) throws Exception {
        Mesa entity = mapper.map(dto, Mesa.class);
        Mesa saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, MesaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaDTO> update(@PathVariable Integer id, @Valid @RequestBody MesaDTO dto) throws Exception {
        Mesa entity = mapper.map(dto, Mesa.class);
        Mesa updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, MesaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<MesaDTO>> findAll() throws Exception {
        List<MesaDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, MesaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> findById(@PathVariable Integer id) throws Exception {
        Mesa entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, MesaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
