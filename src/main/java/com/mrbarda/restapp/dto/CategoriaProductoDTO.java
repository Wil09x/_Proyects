package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoDTO {

    private Integer id;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;
}

