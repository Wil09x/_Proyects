package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El tipo de cliente es obligatorio")
    private String tipoCliente; // NATURAL, JURIDICA

    @NotNull(message = "El tipo de documento es obligatorio")
    private String tipoDocumento; // DNI, RUC

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(min = 8, max = 11)
    private String numeroDocumento;

    private String razonSocial;

    @Pattern(regexp = "^9\\d{8}$", message = "Número de teléfono inválido")
    private String telefono;

    @Email(message = "Correo inválido")
    private String email;

    private Boolean esUsuario;

    private Integer usuarioId;
}
