package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import com.ctd.finalbackend1.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    private ITurnoRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Autowired
    public void setRepository(ITurnoRepository repository) {
        this.repository = repository;
    }


    @Override
    public TurnoDTO buscarPorId(Integer id) {
        Turno turno = repository.findById(id).get();
        TurnoDTO turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public Set<TurnoDTO> buscarTodos() {
        List<Turno> turnos = repository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            TurnoDTO turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
            turnoDTOS.add(turnoDTO);
        }
        return turnoDTOS;
    }

    @Override
    public void eliminarTurno(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        repository.save(turno);
    }

    @Override
    public TurnoDTO agregarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        Turno turnoGuardado = repository.save(turno);
        TurnoDTO turnoDTOGuardado = mapper.convertValue(turnoGuardado, TurnoDTO.class);

        return turnoDTOGuardado;
    }
}
