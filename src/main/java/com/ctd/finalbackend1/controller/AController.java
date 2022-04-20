package com.ctd.finalbackend1.controller;

import com.ctd.finalbackend1.model.ADTO;
import com.ctd.finalbackend1.service.IService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
@Getter
public abstract class AController<Service extends IService<DTO>, DTO extends ADTO> {

    // poner todo en una clase abstracta es buena practica?
    // hay mucho codigo que es igual entre todos
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
    // aca tendria que poner el tipado de el id como un generic??
    // no se si es buena practica, ya este codigo en general es medio como que turbio
    public ResponseEntity<Optional<DTO>> buscarPorId(@PathVariable UUID id) {
        return Optional.ofNullable(service.buscarPorId(id))
                .map(dto -> ResponseEntity.ok().body(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Optional<DTO>> crear(@RequestBody DTO dto) {
        if (dto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return Optional.ofNullable(service.agregar(dto))
                .map(_dto -> ResponseEntity.ok().body(_dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody DTO dto) {
        if (dto.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        service.actualizar(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable UUID id) {
        if (service.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
