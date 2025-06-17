package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.FacturaDTO;
import com.mrbarda.restapp.model.Factura;
import com.mrbarda.restapp.service.IFacturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class
FacturaController {

    private final IFacturaService facturaService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<FacturaDTO> save(@Valid @RequestBody FacturaDTO dto) throws Exception {
        Factura factura = modelMapper.map(dto, Factura.class);
        Factura saved = facturaService.save(factura);
        return ResponseEntity.ok(modelMapper.map(saved, FacturaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDTO> update(@PathVariable Integer id, @Valid @RequestBody FacturaDTO dto) throws Exception {
        Factura factura = modelMapper.map(dto, Factura.class);
        Factura updated = facturaService.update(factura, id);
        return ResponseEntity.ok(modelMapper.map(updated, FacturaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> findAll() throws Exception {
        List<FacturaDTO> list = facturaService.findAll()
                .stream()
                .map(f -> modelMapper.map(f, FacturaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> findById(@PathVariable Integer id) throws Exception {
        Factura factura = facturaService.findById(id);
        return ResponseEntity.ok(modelMapper.map(factura, FacturaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
