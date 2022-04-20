package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService extends AService<Turno, TurnoDTO, ITurnoRepository> {


    public TurnoService() {
        super.setDtoClazz(TurnoDTO.class);
        super.setEntityClazz(Turno.class);
    }


    @Override
    public Optional<TurnoDTO> agregar(TurnoDTO turnoDTO) /*throws Exception*/ {
        PacienteDTO paciente = turnoDTO.getPaciente();
        OdontologoDTO odontologo = turnoDTO.getOdontologo();

        Set<TurnoDTO> turnosPaciente = this.findByPatient(paciente.getId());
        Set<TurnoDTO> turnosOdontologo = this.findByOdontologo(odontologo.getId());

        for (TurnoDTO turno : turnosPaciente) {
            if (turno.getFecha().equals(turnoDTO.getFecha())) {
                // throw exception
            }
        }
        for (TurnoDTO turno : turnosOdontologo) {
            if (turno.getFecha().equals(turnoDTO.getFecha())) {
                // throw exception
            }
        }
        return super.agregar(turnoDTO);
    }

    public Set<TurnoDTO> findByPatient(UUID pacienteId) {
        List<Turno> turnos = super.getRepository().findAllByPaciente_id(pacienteId);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }

    public Set<TurnoDTO> findByOdontologo(UUID odontologoID) {
        List<Turno> turnos = super.getRepository().findAllByOdontologo_id(odontologoID);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }
}
