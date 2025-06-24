package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoDTO {

    private Integer id;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(max = 100)
    private String nombre;
}
