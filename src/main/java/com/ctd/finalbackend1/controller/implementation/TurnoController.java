package com.ctd.finalbackend1.controller.implementation;

import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.service.IService;
import com.ctd.finalbackend1.service.implementation.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController extends AController<IService<TurnoDTO>, TurnoDTO> {

    @GetMapping("/paciente/{id}")
    public ResponseEntity<Set<TurnoDTO>> buscarPorPaciente(@PathVariable Integer id) {
        TurnoService service = (TurnoService) super.getService();
        return ResponseEntity.ok(service.findByPatient(id));
    }

    @GetMapping("/odontologo/{id}")
    public ResponseEntity<Set<TurnoDTO>> buscarPorOdontologo(@PathVariable Integer id) {
        TurnoService service = (TurnoService) super.getService();
        return ResponseEntity.ok(service.findByOdontologo(id));
    }
}
