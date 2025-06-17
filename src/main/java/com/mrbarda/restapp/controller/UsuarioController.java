package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.UsuarioDTO;
import com.mrbarda.restapp.model.Usuario;
import com.mrbarda.restapp.service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService usuarioService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        Usuario saved = usuarioService.save(usuario);
        return ResponseEntity.ok(modelMapper.map(saved, UsuarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO dto) throws Exception {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        Usuario updated = usuarioService.update(usuario, id);
        return ResponseEntity.ok(modelMapper.map(updated, UsuarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() throws Exception {
        List<UsuarioDTO> list = usuarioService.findAll()
                .stream()
                .map(u -> modelMapper.map(u, UsuarioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) throws Exception {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
