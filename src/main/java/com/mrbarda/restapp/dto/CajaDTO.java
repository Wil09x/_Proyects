package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CajaDTO {

    private Integer id;

    @NotNull(message = "La fecha de apertura es obligatoria")
    private LocalDateTime fechaHoraApertura;

    private LocalDateTime fechaHoraCierre;

    @NotNull(message = "El monto inicial es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal montoInicial;

    private BigDecimal montoFinal;

    @NotNull(message = "Debe indicar si está abierta")
    private Boolean abierta;
}
