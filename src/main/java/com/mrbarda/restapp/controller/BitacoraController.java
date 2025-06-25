package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.BitacoraDTO;
import com.mrbarda.restapp.model.Bitacora;
import com.mrbarda.restapp.service.IBitacoraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bitacoras")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BitacoraController {

    private final IBitacoraService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<BitacoraDTO> save(@Valid @RequestBody BitacoraDTO dto) throws Exception {
        Bitacora entity = mapper.map(dto, Bitacora.class);
        Bitacora saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, BitacoraDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BitacoraDTO> update(@PathVariable Integer id, @Valid @RequestBody BitacoraDTO dto) throws Exception {
        Bitacora entity = mapper.map(dto, Bitacora.class);
        Bitacora updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, BitacoraDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<BitacoraDTO>> findAll() throws Exception {
        List<BitacoraDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, BitacoraDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BitacoraDTO> findById(@PathVariable Integer id) throws Exception {
        Bitacora entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, BitacoraDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
