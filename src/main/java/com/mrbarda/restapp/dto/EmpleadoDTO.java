package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {

    private Integer id;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8)
    private String dni;

    @Pattern(regexp = "^9\\d{8}$", message = "Número de teléfono inválido")
    private String telefono;

    @NotNull(message = "El cargo es obligatorio")
    private Integer cargoId;

    private Integer usuarioId;
}

