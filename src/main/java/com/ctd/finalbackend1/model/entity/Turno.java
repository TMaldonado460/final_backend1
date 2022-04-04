package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turno")
@Getter @Setter
public class Turno extends AEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
