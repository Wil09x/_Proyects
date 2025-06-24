package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteProductoDTO {

    private Integer id;

    @NotNull(message = "El producto es obligatorio")
    private Integer productoId;

    @NotNull(message = "El insumo es obligatorio")
    private Integer inventarioId;

    @NotNull(message = "La cantidad requerida es obligatoria")
    @DecimalMin(value = "0.01", message = "Debe ser mayor a 0")
    private BigDecimal cantidadRequerida;
}
