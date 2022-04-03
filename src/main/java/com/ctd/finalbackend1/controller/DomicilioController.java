package com.ctd.finalbackend1.controller;


import com.ctd.finalbackend1.model.DomicilioDTO;
import com.ctd.finalbackend1.model.PacienteDTO;
import com.ctd.finalbackend1.service.implementation.DomicilioService;
import com.ctd.finalbackend1.service.implementation.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @GetMapping
    public ResponseEntity<Set<DomicilioDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DomicilioDTO> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        return ResponseEntity.ok(service.agregarDomicilio(domicilioDTO));
    }

    @PutMapping
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        service.actualizarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDomicilio(@PathVariable Integer id) {
        service.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
