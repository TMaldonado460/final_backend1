package com.ctd.finalbackend1.controller;

import com.ctd.finalbackend1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public abstract class AController<Service extends IService<DTO>, DTO> {

    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Set<DTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DTO> crearDomicilio(@RequestBody DTO dto) {
        return ResponseEntity.ok(service.agregar(dto));
    }

    @PutMapping
    public ResponseEntity<?> actualizarDomicilio(@RequestBody DTO dto) {
        service.actualizar(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarDomicilio(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
