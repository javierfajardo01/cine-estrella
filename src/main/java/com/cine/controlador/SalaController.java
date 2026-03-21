package com.cine.controlador;

import com.cine.modelo.Sala;
import com.cine.servicio.SalaService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> listarTodas() {
        return salaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {
        return salaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sala> crear(@Valid @RequestBody Sala sala) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.crear(sala));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(@PathVariable Long id, @Valid @RequestBody Sala sala) {
        return salaService.buscarPorId(id)
                .map(s -> {
                    sala.setId(id);
                    return ResponseEntity.ok(salaService.crear(sala));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        salaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
