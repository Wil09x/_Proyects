package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El tipo de cliente es obligatorio")
    @Pattern(regexp = "NATURAL|JURIDICA", message = "Tipo de cliente debe ser NATURAL o JURIDICA")
    private String tipoCliente;

    @NotBlank(message = "El tipo de documento es obligatorio")
    @Pattern(regexp = "DNI|RUC", message = "Tipo de documento debe ser DNI o RUC")
    private String tipoDocumento;

    @NotBlank(message = "El número de documento es obligatorio")
    @Size(min = 8, max = 11, message = "El documento debe tener entre 8 y 11 caracteres")
    private String numeroDocumento;

    @Size(max = 100)
    private String razonSocial;

    @Size(max = 20)
    private String telefono;

    @Email(message = "El correo no es válido")
    private String email;

    @NotNull(message = "Debe indicar si es usuario")
    private Boolean esUsuario;

    private Integer usuarioId; // nullable, solo si esUsuario = true
}
