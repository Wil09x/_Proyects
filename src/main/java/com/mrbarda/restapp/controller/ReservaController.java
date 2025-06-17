package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ReservaDTO;
import com.mrbarda.restapp.model.Reserva;
import com.mrbarda.restapp.service.IReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ReservaController {

    private final IReservaService reservaService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@Valid @RequestBody ReservaDTO dto) throws Exception {
        Reserva reserva = modelMapper.map(dto, Reserva.class);
        Reserva saved = reservaService.save(reserva);
        return ResponseEntity.ok(modelMapper.map(saved, ReservaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Integer id, @Valid @RequestBody ReservaDTO dto) throws Exception {
        Reserva reserva = modelMapper.map(dto, Reserva.class);
        Reserva updated = reservaService.update(reserva, id);
        return ResponseEntity.ok(modelMapper.map(updated, ReservaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() throws Exception {
        List<ReservaDTO> reservas = reservaService.findAll().stream()
                .map(r -> modelMapper.map(r, ReservaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Integer id) throws Exception {
        Reserva reserva = reservaService.findById(id);
        return ResponseEntity.ok(modelMapper.map(reserva, ReservaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
