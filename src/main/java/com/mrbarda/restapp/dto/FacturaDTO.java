package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Integer id;

    private LocalDateTime fechaEmision;

    @NotNull(message = "El cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "El pedido es obligatorio")
    private Integer pedidoId;

    @NotBlank(message = "El tipo de comprobante es obligatorio")
    private String tipoComprobante;

    @NotBlank(message = "La serie es obligatoria")
    private String numeroSerie;

    @NotBlank(message = "El número de documento es obligatorio")
    private String numeroDocumento;

    @NotBlank(message = "La forma de pago es obligatoria")
    private String formaPago;

    private BigDecimal total;

    private Boolean anulado;
}

