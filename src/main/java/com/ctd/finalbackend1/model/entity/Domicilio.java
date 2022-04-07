package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@Setter @Getter
public class Domicilio extends AEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // private String paciente_id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;

}
