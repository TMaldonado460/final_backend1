package com.ctd.finalbackend1.controller;

import com.ctd.finalbackend1.model.PacienteDTO;
import com.ctd.finalbackend1.service.implementation.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(service.agregarPaciente(pacienteDTO));
    }

    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        service.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Integer id) {
        service.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
