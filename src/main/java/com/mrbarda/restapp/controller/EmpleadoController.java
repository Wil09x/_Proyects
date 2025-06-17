package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.EmpleadoDTO;
import com.mrbarda.restapp.model.Empleado;
import com.mrbarda.restapp.service.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> save(@Valid @RequestBody EmpleadoDTO dto) throws Exception {
        Empleado empleado = modelMapper.map(dto, Empleado.class);
        Empleado saved = empleadoService.save(empleado);
        return ResponseEntity.ok(modelMapper.map(saved, EmpleadoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Integer id, @Valid @RequestBody EmpleadoDTO dto) throws Exception {
        Empleado empleado = modelMapper.map(dto, Empleado.class);
        Empleado updated = empleadoService.update(empleado, id);
        return ResponseEntity.ok(modelMapper.map(updated, EmpleadoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> findAll() throws Exception {
        List<EmpleadoDTO> list = empleadoService.findAll()
                .stream()
                .map(e -> modelMapper.map(e, EmpleadoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Integer id) throws Exception {
        Empleado empleado = empleadoService.findById(id);
        return ResponseEntity.ok(modelMapper.map(empleado, EmpleadoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
