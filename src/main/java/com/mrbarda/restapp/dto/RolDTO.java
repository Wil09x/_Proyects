package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {

    private Integer id;

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Size(max = 50)
    private String nombre;
}

