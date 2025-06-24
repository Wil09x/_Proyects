package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDTO {

    private Integer id;

    @NotBlank(message = "El nombre del insumo es obligatorio")
    @Size(max = 100)
    private String nombreInsumo;

    @NotBlank(message = "La unidad de medida es obligatoria")
    private String unidadMedida; // kg, litros, unidades

    @NotNull(message = "La cantidad disponible es obligatoria")
    @DecimalMin(value = "0.00")
    private BigDecimal cantidadDisponible;
}
