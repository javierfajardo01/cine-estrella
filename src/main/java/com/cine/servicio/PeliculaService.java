package com.cine.servicio;

import com.cine.modelo.Pelicula;
import com.cine.repositorio.PeliculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> listarTodas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> buscarPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    @Transactional
    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Transactional
    public Pelicula actualizar(Long id, Pelicula peliculaDetalles) {
        return peliculaRepository.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(peliculaDetalles.getTitulo());
                    pelicula.setDirector(peliculaDetalles.getDirector());
                    pelicula.setDuracion(peliculaDetalles.getDuracion());
                    pelicula.setClasificacion(peliculaDetalles.getClasificacion());
                    return peliculaRepository.save(pelicula);
                }).orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id: " + id));
    }

    @Transactional
    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }
}
