package com.ctd.finalbackend1.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IService<DTO> {
    DTO buscarPorId(Integer id);
    Set<DTO> buscarTodos();
    void eliminar(Integer id);
    void actualizar(DTO dto);
    DTO agregar(DTO dto);
}
