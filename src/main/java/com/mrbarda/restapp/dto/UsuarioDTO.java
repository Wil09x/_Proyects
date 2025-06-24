package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 100)
    private String password;

    @NotNull(message = "El estado activo es obligatorio")
    private Boolean activo;

    @NotEmpty(message = "Debe tener al menos un rol")
    private Set<Integer> rolesIds;
}
