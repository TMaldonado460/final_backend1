package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService extends AService<Paciente, PacienteDTO, IPacienteRepository> {

    private IPacienteRepository repository;
    private ObjectMapper mapper;


    @Autowired
    public void setRepository(IPacienteRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public PacienteDTO buscarPorId(Integer id) {
        Optional<Paciente> paciente = repository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
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
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        repository.save(paciente);
    }

    @Override
    public PacienteDTO agregar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Paciente pacienteGuardado = repository.save(paciente);
        return mapper.convertValue(pacienteGuardado, PacienteDTO.class);
    }
}