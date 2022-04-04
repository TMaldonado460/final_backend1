package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.OdontologoDTO;
import com.ctd.finalbackend1.model.entity.Odontologo;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository repository;
    private ObjectMapper mapper;


    @Autowired
    public void setRepository(IOdontologoRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public OdontologoDTO buscarPorId(Integer id) {
        Optional<Odontologo> odontologo = repository.findById(id);
        OdontologoDTO odontologoDTO = null;

        if(odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologosList = repository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();

        for(Odontologo odontologo : odontologosList) {
            OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            odontologoDTOS.add(odontologoDTO);
        }

        return odontologoDTOS;
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        repository.save(odontologo);
    }

    @Override
    public OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        Odontologo odontologo1 = repository.save(odontologo);
        return mapper.convertValue(odontologo1, OdontologoDTO.class);

    }
}
