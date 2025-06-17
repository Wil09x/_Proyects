package com.mrbarda.restapp.service;

import com.mrbarda.restapp.dto.ReporteDiarioDTO;

import java.util.List;

public interface IReporteDiarioService {
    List<ReporteDiarioDTO> findAll();
    ReporteDiarioDTO findByFecha(String fecha);
}


