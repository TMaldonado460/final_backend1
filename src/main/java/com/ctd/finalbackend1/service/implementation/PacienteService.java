package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService extends AService<Paciente, PacienteDTO, IPacienteRepository> {
    public PacienteService() {
        super.setDtoClazz(PacienteDTO.class);
        super.setEntityClazz(Paciente.class);
    }

    // necesario override para agregarle el paciente a los domicilios (paciente <-> domicilio) es bidireccional
    @Override
    public Optional<PacienteDTO> agregar(PacienteDTO dto) {
        Paciente paciente = super.getMapper().convertValue(dto, Paciente.class);
        if (dto.getDomicilios() != null) {
            for (Domicilio domicilio : paciente.getDomicilios()) {
                domicilio.setPaciente(paciente);
            }
        }
        Paciente pacienteGuardado = super.getRepository().save(paciente);
        return Optional.of(super.getMapper().convertValue(pacienteGuardado, PacienteDTO.class));
    }
}