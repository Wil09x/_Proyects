package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @Pattern(regexp = "DNI|RUC", message = "Debe ser DNI o RUC")
    private String tipoDocumento;

    @Size(max = 20)
    private String numeroDocumento;

    @Size(max = 100)
    private String razonSocial;

    @Size(max = 20)
    private String telefono;

    @Email(message = "Correo no válido")
    private String email;

    @Size(max = 200)
    private String direccion;

    @NotNull
    private Boolean activo;
}
