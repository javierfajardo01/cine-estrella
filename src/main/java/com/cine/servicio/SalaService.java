package com.cine.servicio;

import com.cine.modelo.Sala;
import com.cine.repositorio.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> buscarPorId(Long id) {
        return salaRepository.findById(id);
    }

    @Transactional
    public Sala crear(Sala sala) {
        return salaRepository.save(sala);
    }

    @Transactional
    public Sala actualizar(Long id, Sala salaDetalles) {
        return salaRepository.findById(id)
                .map(sala -> {
                    sala.setNumero(salaDetalles.getNumero());
                    sala.setCapacidadMaxima(salaDetalles.getCapacidadMaxima());
                    sala.setTiene3D(salaDetalles.isTiene3D());
                    return salaRepository.save(sala);
                }).orElseThrow(() -> new RuntimeException("Sala no encontrada con id: " + id));
    }

    @Transactional
    public void eliminar(Long id) {
        salaRepository.deleteById(id);
    }

}
