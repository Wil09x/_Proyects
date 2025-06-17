package com.mrbarda.restapp.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDiarioDTO {

    private Integer id;
    private LocalDate fecha;
    private BigDecimal totalVentas;
    private Integer pedidosAtendidos;
    private Integer reservasRegistradas;
    private BigDecimal totalCaja;
}
