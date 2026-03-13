package com.cine.controlador;


import com.cine.modelo.Entrada;
import com.cine.servicio.EntradaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {
    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    @GetMapping
    public List<Entrada> listarTodas() {
        return entradaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> buscarPorId(@PathVariable Long id) {
        return entradaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entrada> crear(@jakarta.validation.Valid @RequestBody Entrada entrada) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entradaService.crear(entrada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrada> actualizar(@PathVariable Long id, @jakarta.validation.Valid @RequestBody Entrada entrada) {
        return entradaService.buscarPorId(id)
                .map(e -> {
                    entrada.setId(id);
                    return ResponseEntity.ok(entradaService.crear(entrada));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entradaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
