package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.PedidoDTO;
import com.mrbarda.restapp.model.Pedido;
import com.mrbarda.restapp.service.IPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService pedidoService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<PedidoDTO> save(@Valid @RequestBody PedidoDTO dto) throws Exception {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        Pedido saved = pedidoService.save(pedido);
        return ResponseEntity.ok(modelMapper.map(saved, PedidoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable Integer id, @Valid @RequestBody PedidoDTO dto) throws Exception {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        Pedido updated = pedidoService.update(pedido, id);
        return ResponseEntity.ok(modelMapper.map(updated, PedidoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() throws Exception {
        List<PedidoDTO> list = pedidoService.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PedidoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Integer id) throws Exception {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok(modelMapper.map(pedido, PedidoDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
