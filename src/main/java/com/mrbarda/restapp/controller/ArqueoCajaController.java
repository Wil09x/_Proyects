package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ArqueoCajaDTO;
import com.mrbarda.restapp.model.ArqueoCaja;
import com.mrbarda.restapp.model.Caja;
import com.mrbarda.restapp.model.Empleado;
import com.mrbarda.restapp.service.IArqueoCajaService;
import com.mrbarda.restapp.service.ICajaService;
import com.mrbarda.restapp.service.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arqueos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ArqueoCajaController {

    private final IArqueoCajaService arqueoService;
    private final ICajaService cajaService;
    private final IEmpleadoService empleadoService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ArqueoCajaDTO> save(@Valid @RequestBody ArqueoCajaDTO dto) throws Exception {
        ArqueoCaja entity = mapDtoToEntity(dto);
        entity.setDiferencia(entity.getMontoDeclarado().subtract(entity.getMontoCalculado()));
        ArqueoCaja saved = arqueoService.save(entity);
        return ResponseEntity.ok(mapEntityToDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ArqueoCajaDTO>> findAll() throws Exception {
        List<ArqueoCajaDTO> list = arqueoService.findAll()
                .stream().map(this::mapEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(mapEntityToDto(arqueoService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArqueoCajaDTO> update(@PathVariable Integer id, @Valid @RequestBody ArqueoCajaDTO dto) throws Exception {
        ArqueoCaja entity = mapDtoToEntity(dto);
        entity.setDiferencia(entity.getMontoDeclarado().subtract(entity.getMontoCalculado()));
        ArqueoCaja updated = arqueoService.update(entity, id);
        return ResponseEntity.ok(mapEntityToDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        arqueoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ArqueoCaja mapDtoToEntity(ArqueoCajaDTO dto) throws Exception {
        ArqueoCaja entity = modelMapper.map(dto, ArqueoCaja.class);
        entity.setCaja(cajaService.findById(dto.getCajaId()));
        entity.setEmpleado(empleadoService.findById(dto.getEmpleadoId()));
        return entity;
    }

    private ArqueoCajaDTO mapEntityToDto(ArqueoCaja entity) {
        ArqueoCajaDTO dto = modelMapper.map(entity, ArqueoCajaDTO.class);
        dto.setCajaId(entity.getCaja().getId());
        dto.setEmpleadoId(entity.getEmpleado().getId());
        return dto;
    }
}
