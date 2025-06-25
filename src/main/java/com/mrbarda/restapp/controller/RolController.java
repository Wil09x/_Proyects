package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.RolDTO;
import com.mrbarda.restapp.model.Rol;
import com.mrbarda.restapp.service.IRolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RolController {

    private final IRolService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<RolDTO> save(@Valid @RequestBody RolDTO dto) throws Exception {
        Rol entity = mapper.map(dto, Rol.class);
        Rol saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, RolDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable Integer id, @Valid @RequestBody RolDTO dto) throws Exception {
        Rol entity = mapper.map(dto, Rol.class);
        Rol updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, RolDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> findAll() throws Exception {
        List<RolDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, RolDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> findById(@PathVariable Integer id) throws Exception {
        Rol entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, RolDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
