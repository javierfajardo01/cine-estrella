package com.cine.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "peliculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título de la película es obligatorio")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El director de la película es obligatorio")
    @Size(min = 2, max = 100, message = "El director debe tener entre 2 y 100 caracteres")
    @Column(nullable = false)
    private String director;

    @Positive(message = "La duración debe ser mayor que 0 min")
    @Column(nullable = false)
    private int duracion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Clasificacion clasificacion;
}
