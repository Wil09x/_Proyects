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

    @NotNull(message = "ID de la caja es obligatorio")
    private Integer cajaId;

    @NotNull(message = "ID del empleado es obligatorio")
    private Integer empleadoId;

    @NotNull(message = "Fecha y hora es obligatoria")
    private LocalDateTime fechaHora;

    @NotNull(message = "Monto declarado es obligatorio")
    @DecimalMin("0.00")
    private BigDecimal montoDeclarado;

    @NotNull(message = "Monto calculado es obligatorio")
    @DecimalMin("0.00")
    private BigDecimal montoCalculado;

    private BigDecimal diferencia;

    @Size(max = 255)
    private String observacion;
}
