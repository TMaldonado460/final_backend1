package com.ctd.finalbackend1.service;

import com.ctd.finalbackend1.exceptions.ResourceNotFoundException;
import com.ctd.finalbackend1.exceptions.TurnoWithDateAlreadyPersisted;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public interface IService<DTO> {
    // no me encanta esto, el tipado del id deberia ser un generic
    /**
    * searchs a repository and returns a DTO of the entity given the id.
    * @param id the id of the DTO to be searched
    * @return the DTO whoms id equals the given one inside an optional wrapper
    * */
    Optional<DTO> buscarPorId(UUID id);

    /**
     * Returns a set of DTOs.
     * @return set of DTOs
     * */
    Set<DTO> buscarTodos();

    /**
     * Creates a new DTO.
     * @param dto the DTO to be created
     * @return the created DTO inside an optional wrapper
     * */
    Optional<DTO> agregar(DTO dto) throws TurnoWithDateAlreadyPersisted;

    /**
     * Updates an existing DTO.
     * @param dto the DTO to be updated
     * */
    void actualizar(DTO dto);

    /**
     * Deletes a DTO.
     * @param id the id of the DTO to be deleted
     * */
    void eliminar(UUID id) throws ResourceNotFoundException;
}
