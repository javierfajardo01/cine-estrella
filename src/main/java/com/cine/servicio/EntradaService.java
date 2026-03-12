package com.cine.servicio;

import com.cine.modelo.Entrada;
import com.cine.repositorio.EntradaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService {

    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    public List<Entrada> listarTodas(){
        return entradaRepository.findAll();
    }

    public Optional<Entrada> buscarPorId(Long id){
        return entradaRepository.findById(id);
    }

    @Transactional
    public Entrada crear(Entrada entrada){
        return entradaRepository.save(entrada);
    }

    @Transactional
    public Entrada actualizar(Long id, Entrada entradaDetalles){
        return entradaRepository.findById(id)
                .map(entrada -> {
                    entrada.setAsiento(entradaDetalles.getAsiento());
                    entrada.setNombreCliente(entradaDetalles.getNombreCliente());
                    entrada.setSesion(entradaDetalles.getSesion());
                    return entradaRepository.save(entrada);
                }).orElseThrow(() -> new RuntimeException("Entrada no encontrada con id: " + id));
    }

    @Transactional
    public void eliminar(Long id){
        entradaRepository.deleteById(id);
    }
}
