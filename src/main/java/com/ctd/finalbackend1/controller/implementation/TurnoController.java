package com.ctd.finalbackend1.controller.implementation;

import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.exceptions.TurnoWithDateAlreadyPersisted;
import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.service.IService;
import com.ctd.finalbackend1.service.implementation.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/turnos")
/**
 * Endpoint para el manejo de turnos
 * /turnos
 *
 * GET:
 *         /turnos/paciente/{id}
 *         /turnos/odontologo/{id}
 *
 * POST:
 *         /turnos
 */
public class TurnoController extends AController<IService<TurnoDTO>, TurnoDTO> {
    @Override
    @PostMapping
    public ResponseEntity<Optional<TurnoDTO>> crear(@RequestBody TurnoDTO turnoDTO){
        try {
            return super.crear(turnoDTO);
        } catch (TurnoWithDateAlreadyPersisted turnoWithDateAlreadyPersisted) {
            return ResponseEntity.badRequest().body(Optional.empty());
        }
    }


    @GetMapping("/paciente/{id}")
    /**
     * Busca los turnos de un paciente
     * @param id
     * @return
     */
    public ResponseEntity<Set<TurnoDTO>> buscarPorPaciente(@PathVariable UUID id) {
        TurnoService service = (TurnoService) super.getService();
        return ResponseEntity.ok(service.findByPatient(id));
    }

    /**
     * Busca los turnos de un odontologo
     * @param id
     * @return
     */
    @GetMapping("/odontologo/{id}")
    public ResponseEntity<Set<TurnoDTO>> buscarPorOdontologo(@PathVariable UUID id) {
        TurnoService service = (TurnoService) super.getService();
        return ResponseEntity.ok(service.findByOdontologo(id));
    }
}
