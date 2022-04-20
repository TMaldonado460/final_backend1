package com.ctd.finalbackend1.repository;

import com.ctd.finalbackend1.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, UUID> {
}
