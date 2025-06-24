package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDiarioDTO {

    private Integer id;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "El total de ventas es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal totalVentas;

    @NotNull(message = "El total en efectivo es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal totalEfectivo;

    @NotNull(message = "El total en tarjeta es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal totalTarjeta;
}
