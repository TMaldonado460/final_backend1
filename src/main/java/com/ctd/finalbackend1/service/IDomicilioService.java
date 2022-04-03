package com.ctd.finalbackend1.service;


import com.ctd.finalbackend1.model.DomicilioDTO;

import java.util.Set;

public interface IDomicilioService {
    DomicilioDTO buscarPorId(Integer id);
    Set<DomicilioDTO> buscarTodos();
    void eliminarDomicilio(Integer id);
    void actualizarDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO agregarDomicilio(DomicilioDTO domicilioDTO);
}
