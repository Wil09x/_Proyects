package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracionEmpresaDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @Size(max = 200)
    private String direccion;

    @Size(max = 100)
    private String telefono;

    @Email(message = "Correo inválido")
    private String email;

    @Size(max = 255)
    private String logoUrl;
}

