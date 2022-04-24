package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.exceptions.TurnoWithDateAlreadyPersisted;
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
    /**
     * saves a TurnoDTO to the database
     * throws an exception if either the Paciente or Odontologo are not found in the database (todo)
     * @param TurnoDTO
     * @return TurnoDTO wrapped in a Optional
    * */
    public Optional<TurnoDTO> agregar(TurnoDTO turnoDTO) throws TurnoWithDateAlreadyPersisted {
        PacienteDTO paciente = turnoDTO.getPaciente();
        OdontologoDTO odontologo = turnoDTO.getOdontologo();

        Set<TurnoDTO> turnosPaciente = this.findByPatient(paciente.getId());
        Set<TurnoDTO> turnosOdontologo = this.findByOdontologo(odontologo.getId());

        for (TurnoDTO turno : turnosPaciente) {
            if (turno.getFecha().equals(turnoDTO.getFecha())) {
                throw new TurnoWithDateAlreadyPersisted();
            }
        }
        for (TurnoDTO turno : turnosOdontologo) {
            if (turno.getFecha().equals(turnoDTO.getFecha())) {
                throw new TurnoWithDateAlreadyPersisted();
            }
        }
        // como paso solo el id del paciente y el id del odontologo, debo buscar el objeto completo
        return Optional.of(super.agregar(turnoDTO).get());
    }

    /**
     * returns a Set of TurnoDTOs that match the given PacienteDTO's ID
     * @param pacienteId the PacienteDTO's ID
     * @return Set<TurnoDTO>
     * */
    public Set<TurnoDTO> findByPatient(UUID pacienteId) {
        List<Turno> turnos = super.getRepository().findAllByPaciente_id(pacienteId);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }

    /**
     * returns a Set of TurnoDTOs that match the given OdontologoDTO's ID
     * @param odontologoID the OdontologoDTO's ID
     * @return Set<TurnoDTO>
     * */
    public Set<TurnoDTO> findByOdontologo(UUID odontologoID) {
        List<Turno> turnos = super.getRepository().findAllByOdontologo_id(odontologoID);
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(super.getMapper().convertValue(turno, TurnoDTO.class));
        }

        return turnoDTOS;
    }
}
