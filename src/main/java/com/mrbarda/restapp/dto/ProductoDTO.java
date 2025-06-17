package com.mrbarda.restapp.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;

    @NotBlank(message = "El nombre del platillo es obligatorio")
    private String nombre;

    @Size(max = 255)
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.00", message = "El precio no puede ser negativo")
    private BigDecimal precio;

    private Integer stock;

    private String urlImagen;

    @NotNull(message = "La categoría es obligatoria")
    private Integer categoriaId;
}

