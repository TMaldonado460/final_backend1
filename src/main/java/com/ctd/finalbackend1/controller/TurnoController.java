package com.ctd.finalbackend1.controller;


import com.ctd.finalbackend1.model.TurnoDTO;
import com.ctd.finalbackend1.service.implementation.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService service;

    @Autowired
    public void setService(TurnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody TurnoDTO turnoDTO) {
        return ResponseEntity.ok(service.agregarTurno(turnoDTO));
    }

    @PutMapping
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turnoDTO) {
        service.actualizarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTurno(@PathVariable Integer id) {
        service.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
