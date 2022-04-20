package com.ctd.finalbackend1.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public interface IService<DTO> {
    // no me encanta esto, el id deberia ser un generic
    Optional<DTO> buscarPorId(UUID id);
    Set<DTO> buscarTodos();
    void eliminar(UUID id);
    void actualizar(DTO dto);
    Optional<DTO> agregar(DTO dto);
}
