package com.cine.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "salas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "El número de la sala debe ser mayor que 0")
    @Column(nullable = false)
    private int numero;

    @Positive(message = "La capacidad máxima debe ser mayor que 0")
    @Column(nullable = false)
    private int capacidadMaxima;

    @Column(nullable = false)
    private boolean tiene3D;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Sesion> sesiones;
}
