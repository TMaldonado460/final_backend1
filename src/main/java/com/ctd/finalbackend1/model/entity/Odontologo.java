package com.ctd.finalbackend1.model.entity;

import com.ctd.finalbackend1.model.AEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odontologo")
@Setter @Getter
public class Odontologo extends AEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
