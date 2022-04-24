package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "turno")
@Getter @Setter
public class Turno extends AEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private Date fecha;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
