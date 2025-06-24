package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesaDTO {

    private Integer id;

    @NotNull(message = "El número de mesa es obligatorio")
    private Integer numero;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(1)
    private Integer capacidad;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "DISPONIBLE|RESERVADA|OCUPADA", message = "Debe ser DISPONIBLE, RESERVADA u OCUPADA")
    private String estado;
}

