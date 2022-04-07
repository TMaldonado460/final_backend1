package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.stereotype.Service;


@Service
public class PacienteService extends AService<Paciente, PacienteDTO, IPacienteRepository> {
    public PacienteService() {
        super.setDtoClazz(PacienteDTO.class);
        super.setEntityClass(Paciente.class);
    }
}