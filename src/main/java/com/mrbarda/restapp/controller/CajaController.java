package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.CajaDTO;
import com.mrbarda.restapp.model.Caja;
import com.mrbarda.restapp.service.ICajaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cajas")
@CrossOrigin(origins = "http://localhost:4200")
public class CajaController {

    private final ICajaService cajaService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CajaDTO> save(@Valid @RequestBody CajaDTO dto) throws Exception {
        Caja caja = modelMapper.map(dto, Caja.class);
        Caja saved = cajaService.save(caja);
        return ResponseEntity.ok(modelMapper.map(saved, CajaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CajaDTO>> findAll() throws Exception {
        List<CajaDTO> list = cajaService.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CajaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CajaDTO> findById(@PathVariable Integer id) throws Exception {
        Caja caja = cajaService.findById(id);
        return ResponseEntity.ok(modelMapper.map(caja, CajaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CajaDTO> update(@PathVariable Integer id, @Valid @RequestBody CajaDTO dto) throws Exception {
        Caja caja = modelMapper.map(dto, Caja.class);
        Caja updated = cajaService.update(caja, id);
        return ResponseEntity.ok(modelMapper.map(updated, CajaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        cajaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
