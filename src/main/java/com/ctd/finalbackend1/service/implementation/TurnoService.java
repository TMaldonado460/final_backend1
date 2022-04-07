package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService extends AService<Turno, TurnoDTO, ITurnoRepository> {

    public TurnoService() {
        super.setDtoClazz(TurnoDTO.class);
        super.setEntityClass(Turno.class);
    }

    public Set<TurnoDTO> findByPatient(Integer pacienteId) {
        List<Turno> turnos = super.getRepository().findAllByPaciente_id(pacienteId);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }

    public Set<TurnoDTO> findByOdontologo(Integer odontologoID) {
        List<Turno> turnos = super.getRepository().findAllByOdontologo_id(odontologoID);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }
}
