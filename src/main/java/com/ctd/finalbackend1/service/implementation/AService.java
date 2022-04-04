package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.ADTO;
import com.ctd.finalbackend1.model.AEntity;
import com.ctd.finalbackend1.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public abstract class AService<Entity, DTO, Repository extends JpaRepository<Entity, Integer>> implements IService<DTO> {
    private Repository repository;
    private ObjectMapper mapper;

    Class<DTO> dtoClazz =  (Class<DTO>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
    Class<Entity> entityClass =  (Class<Entity>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];



    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ObjectMapper mapper) { this.mapper = mapper; }

    @Override
    public DTO buscarPorId(Integer id) {
        Optional<Entity> entity = repository.findById(id);
        DTO dto = null;
        if(entity.isPresent()) {
            dto = mapper.convertValue(entity, dtoClazz);
        }
        return dto;
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
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizar(DTO dto) {
        Entity entity = mapper.convertValue(dto, entityClass);
        repository.save(entity);
    }

    @Override
    public DTO agregar(DTO dto) {
        Entity entity = mapper.convertValue(dto, entityClass);
        repository.save(entity);
        return mapper.convertValue(entity, dtoClazz);
    }
}
