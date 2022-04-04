package com.ctd.finalbackend1.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "paciente")
@Setter @Getter
public class Paciente {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    @OneToMany(mappedBy = "paciente")
    private Set<Domicilio> domicilios;
}
