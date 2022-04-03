package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.OdontologoDTO;
import com.ctd.finalbackend1.model.entity.Odontologo;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository repository;
    @Autowired
    ObjectMapper mapper;


    @Autowired
    public void setRepository(IOdontologoRepository repository) {
        this.repository = repository;
    }



    @Override
    public OdontologoDTO buscarPorId(Integer id) {
        Odontologo odontologo = repository.findById(id).get();
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
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
        OdontologoDTO odontologoDTO1 = mapper.convertValue(odontologo1, OdontologoDTO.class);
        return odontologoDTO1;

    }
}
