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

    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;

    @NotNull(message = "El saldo inicial es obligatorio")
    @DecimalMin(value = "0.00")
    private BigDecimal saldoInicial;

    private BigDecimal saldoFinal;

    private Boolean cerrada;

    @NotNull(message = "El encargado es obligatorio")
    private Integer encargadoId;
}

