package com.ctd.finalbackend1.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odontrologo")
@Setter @Getter
public class Odontologo {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
