package com.ctd.finalbackend1.service;

import com.ctd.finalbackend1.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    OdontologoDTO buscarPorId(Integer id);
    Set<OdontologoDTO> buscarTodos();
    void eliminarOdontologo(Integer id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO agregarOdontologo(OdontologoDTO odontologoDTO);
}