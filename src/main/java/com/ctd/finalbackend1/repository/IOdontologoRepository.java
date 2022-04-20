package com.ctd.finalbackend1.repository;

import com.ctd.finalbackend1.model.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, UUID> {
}
