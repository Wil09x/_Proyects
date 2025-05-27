package com.lectorium.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Clase que representa el modelo Book (libro).
 * Este modelo se convierte en una tabla en la base de datos.
 */
@Entity
@Data // Lombok: crea getters, setters, toString, equals y hashCode automáticamente
@NoArgsConstructor // Lombok: crea constructor sin argumentos
@AllArgsConstructor // Lombok: crea constructor con todos los campos
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 1000, message = "La descripción debe tener entre 10 y 1000 caracteres")
    private String description;

    @NotBlank(message = "El autor es obligatorio")
    private String author;

    @NotNull(message = "El año de publicación es obligatorio")
    @Min(value = 1500, message = "El año mínimo permitido es 1500")
    @Max(value = 2050, message = "El año máximo permitido es 2050")
    private Integer yearPublished;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Debe seleccionar una categoría")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull(message = "Debe seleccionar una editorial")
    private Publisher publisher;

}
