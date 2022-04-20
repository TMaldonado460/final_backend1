package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "domicilio")
@Setter @Getter

public class Domicilio extends AEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // private String paciente_id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties("domicilios")
    private Paciente paciente;

}
