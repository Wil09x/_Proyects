package com.mrbarda.restapp.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Integer id;

    @NotNull(message = "El cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "La mesa es obligatoria")
    private Integer mesaId;

    @NotNull(message = "La fecha y hora de reserva es obligatoria")
    private LocalDateTime fechaHora;

    @NotNull(message = "El número de personas es obligatorio")
    @Min(value = 1, message = "Debe haber al menos 1 persona")
    private Integer numeroPersonas;

    @NotBlank(message = "El estado es obligatorio")
    private String estado; // PENDIENTE, CONFIRMADA, CANCELADA
}
