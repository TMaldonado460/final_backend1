package com.ctd.finalbackend1.repository;

import com.ctd.finalbackend1.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, UUID> {

    @Query
    public List<Turno> findAllByPaciente_id(UUID paciente_id);

    @Query
    public List<Turno> findAllByOdontologo_id(UUID odontologo_id);
}
