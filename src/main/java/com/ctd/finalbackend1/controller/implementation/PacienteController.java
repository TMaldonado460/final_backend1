package com.ctd.finalbackend1.controller.implementation;

import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.service.IService;
import com.ctd.finalbackend1.service.implementation.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/pacientes")
/**
 * Endpoint para el manejo de pacientes
 * POST:
 *          /pacientes/{id}/domicilio
 *
 * PUT:
 *          /pacientes/{id}/domicilio
 */
public class PacienteController extends AController<IService<PacienteDTO>, PacienteDTO> {
    @Autowired
    private DomicilioService domicilioService;

    /**
     * Introduce un domicilio al paciente con el id pasado por parametro
     * @param id
     * @param domicilioDTO
     * @return
     */
    @PostMapping("/{id}/domicilio")
    public ResponseEntity<Optional<DomicilioDTO>> addDomicilio(@PathVariable("id") UUID id, @RequestBody DomicilioDTO domicilioDTO) {
        // seteamos el paciente del domicilio (no se si esto es necesario, pasando id dentro de la request??)
        domicilioDTO.setPaciente(super.getService().buscarPorId(id).get());
        // Optional de algo que puede ser nulo -> mapeado a un response entity -> si es nulo, devuelve un 404
        return Optional.ofNullable(domicilioService.guardar(domicilioDTO))
                .map(_dto -> ResponseEntity.ok().body(_dto))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualiza el domicilio del paciente con el id pasado por parametro
     * @param id
     * @param domicilioDTO
     * @return
     */
    @PutMapping("/{id}/domicilio")
    public ResponseEntity<?> updateDomicilio(@PathVariable("id") UUID id, @RequestBody DomicilioDTO domicilioDTO) {
        domicilioDTO.setPaciente(super.getService().buscarPorId(id).get());
        domicilioService.guardar(domicilioDTO);
        return ResponseEntity.ok().build();
    }
}