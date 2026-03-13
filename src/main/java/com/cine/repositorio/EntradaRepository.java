package com.cine.repositorio;

import com.cine.modelo.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    List<Entrada> findBySesionId(Long sesionId);

    List<Entrada> findByNombreCliente(String nombreCliente);

    List<Entrada> findByAsiento(int asiento);

    List<Entrada> findBySesionIdAndAsiento(Long sesionId, int asiento);
}
