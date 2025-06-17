package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String tipoDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(min = 8, max = 11)
    private String numeroDocumento;

    private String razonSocial;

    @Pattern(regexp = "^9\\d{8}$", message = "Número telefónico inválido")
    private String telefono;

    @Email
    private String email;

    private String direccion;
}
