package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DomicilioDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    private IDomicilioRepository repository;
    private ObjectMapper mapper;


    @Autowired
    public void setRepository(IDomicilioRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public DomicilioDTO buscarPorId(Integer id) {
        Optional<Domicilio> domicilio = repository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> buscarTodos() {
        List<Domicilio> domicilios = repository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();

        for (Domicilio domicilio : domicilios) {
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return domicilioDTOS;
    }

    @Override
    public void eliminarDomicilio(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        repository.save(domicilio);
    }

    @Override
    public DomicilioDTO agregarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        repository.save(domicilio);
        return mapper.convertValue(domicilio, DomicilioDTO.class);
    }
}
