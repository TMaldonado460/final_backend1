package com.ctd.finalbackend1.service;

import com.ctd.finalbackend1.exceptions.ResourceNotFoundException;
import com.ctd.finalbackend1.exceptions.TurnoWithDateAlreadyPersisted;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter
public abstract class AService<Entity, DTO, Repository extends JpaRepository<Entity, UUID>> implements IService<DTO> {
    private Repository repository;
    private ObjectMapper mapper;

    private Class<DTO> dtoClazz;
    private Class<Entity> entityClazz;

    // necesario, porque tener el tipado de generics tiene sus mañas, me parecio mas facil hacerlo
    // capaz intentar con @
    /**
    * method to set the class of the DTO of the generics
    *
    * @param dtoClazz the class of the DTO
    * */
    public void setDtoClazz(Class<DTO> dtoClazz) {
        this.dtoClazz = dtoClazz;
    }
    /**
     * method to set the class of the DTO of the generics
     *
     * @param entityClazz the class of the entity
     * */
    public void setEntityClazz(Class<Entity> entityClazz) {this.entityClazz = entityClazz;}

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public Optional<DTO> buscarPorId(UUID id) {
        Optional<Entity> entity = repository.findById(id);
        DTO dto = null;
        if(entity.isPresent()) {
            dto = mapper.convertValue(entity, dtoClazz);
        }
        return Optional.of(dto);
    }

    @Override
    public Set<DTO> buscarTodos() {
        List<Entity> entitys = repository.findAll();
        Set<DTO> DTOs = new HashSet<>();

        for (Entity entity : entitys) {
            DTOs.add(mapper.convertValue(entity, dtoClazz));
        }

        return DTOs;
    }

    @Override
    public void eliminar(UUID id) throws ResourceNotFoundException {
        Optional.ofNullable(repository.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException());
        repository.deleteById(id);
    }

    @Override
    public void actualizar(DTO dto) {
        Entity entity = mapper.convertValue(dto, entityClazz);
        repository.save(entity);
    }

    @Override
    public Optional<DTO> agregar(DTO dto) throws TurnoWithDateAlreadyPersisted {
        Entity entity = mapper.convertValue(dto, entityClazz);
        Entity saved = repository.save(entity);
        return Optional.of(mapper.convertValue(saved, dtoClazz));
    }
}
