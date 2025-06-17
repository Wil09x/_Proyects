package com.mrbarda.restapp.service.impl;

import com.mrbarda.restapp.dto.ReporteDiarioDTO;
import com.mrbarda.restapp.repo.IReporteDiarioRepo;
import com.mrbarda.restapp.service.IReporteDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteDiarioService implements IReporteDiarioService {

    private final IReporteDiarioRepo repo;

    @Override
    public List<ReporteDiarioDTO> findAll() {
        return repo.findAllProjected();
    }

    @Override
    public ReporteDiarioDTO findByFecha(String fecha) {
        return repo.findByFecha(LocalDate.parse(fecha))
                .orElseThrow(() -> new RuntimeException("No hay reporte para la fecha: " + fecha));
    }
}
