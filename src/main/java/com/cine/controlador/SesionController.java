package com.cine.controlador;


import com.cine.modelo.Sesion;
import com.cine.servicio.SesionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {
    private final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @GetMapping
    public List<Sesion> listarTodas() {
        return sesionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> buscarPorId(@PathVariable Long id) {
        return sesionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sesion> crear(@jakarta.validation.Valid @RequestBody Sesion sesion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sesionService.crear(sesion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion> actualizar(@PathVariable Long id, @jakarta.validation.Valid @RequestBody Sesion sesion) {
        return sesionService.buscarPorId(id)
                .map(s -> {
                    sesion.setId(id);
                    return ResponseEntity.ok(sesionService.crear(sesion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sesionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
