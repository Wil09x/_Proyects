package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {

    private Integer id;

    @NotNull(message = "El ID del platillo es obligatorio")
    private Integer platilloId;

    @NotNull(message = "El precio unitario es obligatorio")
    private BigDecimal precioUnitario;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(1)
    private Integer cantidad;

    private BigDecimal subtotal;
}

