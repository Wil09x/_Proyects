package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArqueoCajaDTO {

    private Integer id;

    @NotNull(message = "La fecha y hora es obligatoria")
    private LocalDateTime fechaHora;

    @NotNull(message = "El monto declarado es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal montoDeclarado;

    @NotNull(message = "El monto calculado es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal montoCalculado;

    @Size(max = 255)
    private String observacion;
}

