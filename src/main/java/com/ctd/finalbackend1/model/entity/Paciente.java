package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "paciente")
@Setter @Getter
public class Paciente extends AEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Set<Domicilio> domicilios;
}
