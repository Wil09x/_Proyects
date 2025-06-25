package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.DetallePedidoDTO;
import com.mrbarda.restapp.model.DetallePedido;
import com.mrbarda.restapp.service.IDetallePedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle-pedido")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DetallePedidoController {

    private final IDetallePedidoService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> save(@Valid @RequestBody DetallePedidoDTO dto) throws Exception {
        DetallePedido entity = mapper.map(dto, DetallePedido.class);
        DetallePedido saved = service.save(entity);
        return ResponseEntity.ok(mapper.map(saved, DetallePedidoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> update(@PathVariable Integer id, @Valid @RequestBody DetallePedidoDTO dto) throws Exception {
        DetallePedido entity = mapper.map(dto, DetallePedido.class);
        DetallePedido updated = service.update(entity, id);
        return ResponseEntity.ok(mapper.map(updated, DetallePedidoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> findAll() throws Exception {
        List<DetallePedidoDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, DetallePedidoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable Integer id) throws Exception {
        DetallePedido entity = service.findById(id);
        return ResponseEntity.ok(mapper.map(entity, DetallePedidoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

