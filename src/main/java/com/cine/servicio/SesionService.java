package com.cine.servicio;

import com.cine.modelo.Entrada;
import com.cine.modelo.Pelicula;
import com.cine.modelo.Sala;
import com.cine.modelo.Sesion;
import com.cine.repositorio.PeliculaRepository;
import com.cine.repositorio.SalaRepository;
import com.cine.repositorio.SesionRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
    private final SesionRepository sesionRepository;
    private final PeliculaRepository peliculaRepository;
    private final SalaRepository salaRepository;

    public SesionService(SesionRepository sesionRepository, PeliculaRepository peliculaRepository, SalaRepository salaRepository) {
        this.sesionRepository = sesionRepository;
        this.peliculaRepository = peliculaRepository;
        this.salaRepository = salaRepository;
    }

    public List<Sesion> listarTodas() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> buscarPorId(Long id) {
        return sesionRepository.findById(id);
    }

    @Transactional
    public Sesion crear(Sesion sesion) {
        // 1. Validar y cargar Pelicula y Sala
        if (sesion.getPelicula() != null && sesion.getPelicula().getId() != null) {
            Pelicula pelicula = peliculaRepository.findById(sesion.getPelicula().getId())
                    .orElseThrow(() -> new RuntimeException("Pelicula no encontrada"));
            sesion.setPelicula(pelicula);
        }

        if (sesion.getSala() != null && sesion.getSala().getId() != null) {
            Sala sala = salaRepository.findById(sesion.getSala().getId())
                    .orElseThrow(() -> new RuntimeException("Sala no encontrada"));
            sesion.setSala(sala);
        }

        // 2. Gestionar la relación bidireccional con Entradas
        if (sesion.getEntradas() != null) {
            for (Entrada entrada : sesion.getEntradas()) {
                entrada.setSesion(sesion); // Vincular la entrada a la sesión
                entrada.setId(null);       // Asegurar que se trata como una nueva entrada
            }
        }

        return sesionRepository.save(sesion);
    }

    @Transactional
    public Sesion actualizar(Long id, Sesion sesionDetalles) {
        Sesion sesion = sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sesion no encontrada con id: " + id));

        // Cargar las entidades Pelicula y Sala desde la base de datos
        Pelicula pelicula = peliculaRepository.findById(sesionDetalles.getPelicula().getId())
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada"));
        Sala sala = salaRepository.findById(sesionDetalles.getSala().getId())
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        sesion.setFechaHora(sesionDetalles.getFechaHora());
        sesion.setPrecio(sesionDetalles.getPrecio());
        sesion.setPelicula(pelicula); // Asignar la entidad gestionada
        sesion.setSala(sala);         // Asignar la entidad gestionada

        return sesion; // No es necesario save(), @Transactional lo hace
    }

    @Transactional
    public void eliminar(Long id) {
        sesionRepository.deleteById(id);
    }

}
