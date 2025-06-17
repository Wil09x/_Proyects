package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.TurnoEmpleadoDTO;
import com.mrbarda.restapp.model.TurnoEmpleado;
import com.mrbarda.restapp.service.ITurnoEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TurnoEmpleadoController {

    private final ITurnoEmpleadoService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TurnoEmpleadoDTO> save(@Valid @RequestBody TurnoEmpleadoDTO dto) throws Exception {
        TurnoEmpleado entity = modelMapper.map(dto, TurnoEmpleado.class);
        TurnoEmpleado saved = service.save(entity);
        return ResponseEntity.ok(modelMapper.map(saved, TurnoEmpleadoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoEmpleadoDTO> update(@PathVariable Integer id, @Valid @RequestBody TurnoEmpleadoDTO dto) throws Exception {
        TurnoEmpleado entity = modelMapper.map(dto, TurnoEmpleado.class);
        TurnoEmpleado updated = service.update(entity, id);
        return ResponseEntity.ok(modelMapper.map(updated, TurnoEmpleadoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<TurnoEmpleadoDTO>> findAll() throws Exception {
        List<TurnoEmpleadoDTO> list = service.findAll()
                .stream()
                .map(t -> modelMapper.map(t, TurnoEmpleadoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoEmpleadoDTO> findById(@PathVariable Integer id) throws Exception {
        TurnoEmpleado entity = service.findById(id);
        return ResponseEntity.ok(modelMapper.map(entity, TurnoEmpleadoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
