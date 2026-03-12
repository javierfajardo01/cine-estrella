package com.cine.repositorio;

import com.cine.modelo.Pelicula;
import com.cine.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Encontrar Peliculas por su clasificación
    List<Pelicula> findByClasificacion(String clasificacion);

    // Encontrar Peliculas por titulo
    List<Pelicula> findByTitulo(String titulo);
}
