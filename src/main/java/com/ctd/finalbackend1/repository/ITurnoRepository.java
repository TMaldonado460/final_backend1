package com.ctd.finalbackend1.repository;

import com.ctd.finalbackend1.model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, UUID> {

    @Query
    /**
     * find all turnos by paciente_id inside database
     * @param paciente_id
     * @return List<Turno>
    * */
    public List<Turno> findAllByPaciente_id(UUID paciente_id);

    @Query
    /**
     * find all turnos by odontologo_id inside database
     * @param odontologo_id
     * @return List<Turno>
    * */
    public List<Turno> findAllByOdontologo_id(UUID odontologo_id);
}
