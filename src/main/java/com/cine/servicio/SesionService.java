package com.cine.servicio;

import com.cine.modelo.Sesion;
import com.cine.repositorio.SesionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
    private final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public List<Sesion> listarTodas() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> buscarPorId(Long id) {
        return sesionRepository.findById(id);
    }

    @Transactional
    public Sesion crear(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    @Transactional
    public Sesion actualizar(Long id, Sesion sesionDetalles) {
        return sesionRepository.findById(id)
                .map(sesion -> {
                    sesion.setFechaHora(sesionDetalles.getFechaHora());
                    sesion.setPrecio(sesionDetalles.getPrecio());
                    sesion.setPelicula(sesionDetalles.getPelicula());
                    sesion.setSala(sesionDetalles.getSala());
                    return sesionRepository.save(sesion);
                }).orElseThrow(() -> new RuntimeException("Sesion no encontrada con id: " + id));
    }

    @Transactional
    public void eliminar(Long id) {
        sesionRepository.deleteById(id);
    }

}
