package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ClienteDTO;
import com.mrbarda.restapp.model.Cliente;
import com.mrbarda.restapp.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody @Valid ClienteDTO dto) throws Exception {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        Cliente saved = clienteService.save(cliente);
        return ResponseEntity.ok(modelMapper.map(saved, ClienteDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody @Valid ClienteDTO dto) throws Exception {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        Cliente updated = clienteService.update(cliente, id);
        return ResponseEntity.ok(modelMapper.map(updated, ClienteDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() throws Exception {
        List<ClienteDTO> list = clienteService.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ClienteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) throws Exception {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(modelMapper.map(cliente, ClienteDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
