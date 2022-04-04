package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    private IPacienteRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Autowired
    public void setRepository(IPacienteRepository repository) {
        this.repository = repository;
    }



    @Override
    public PacienteDTO buscarPorId(Integer id) {
        Paciente paciente = repository.findById(id).get();
        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public Set<PacienteDTO> buscarTodos() {
        List<Paciente> pacienteList = repository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();

        for(Paciente paciente : pacienteList) {
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacienteDTOS.add(pacienteDTO);
        }

        return pacienteDTOS;
    }

    @Override
    public void eliminarPaciente(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        repository.save(paciente);
    }

    @Override
    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Paciente pacienteGuardado = repository.save(paciente);
        PacienteDTO pacienteDTOGuardado = mapper.convertValue(pacienteGuardado, PacienteDTO.class);
        return pacienteDTOGuardado;
    }
}