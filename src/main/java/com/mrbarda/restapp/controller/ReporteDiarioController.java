package com.mrbarda.restapp.controller;

import com.mrbarda.restapp.dto.ReporteDiarioDTO;
import com.mrbarda.restapp.service.IReporteDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ReporteDiarioController {

    private final IReporteDiarioService service;

    @GetMapping
    public ResponseEntity<List<ReporteDiarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{fecha}")
    public ResponseEntity<ReporteDiarioDTO> findByFecha(@PathVariable String fecha) {
        return ResponseEntity.ok(service.findByFecha(fecha));
    }
}
