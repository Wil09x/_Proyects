package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100)
    private String nombre;

    @Size(max = 300)
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotBlank(message = "La imagen es obligatoria")
    private String imagenUrl;

    @NotNull(message = "La categoría es obligatoria")
    private Integer categoriaId;
}
