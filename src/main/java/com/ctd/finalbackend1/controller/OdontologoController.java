package com.ctd.finalbackend1.controller;

import com.ctd.finalbackend1.model.OdontologoDTO;
import com.ctd.finalbackend1.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private IOdontologoService service;

    @Autowired
    public void setService(IOdontologoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return ResponseEntity.ok(service.agregarOdontologo(odontologoDTO));
    }

    @PutMapping
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        service.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable Integer id) {
        service.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
