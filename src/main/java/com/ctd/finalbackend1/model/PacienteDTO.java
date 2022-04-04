package com.ctd.finalbackend1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter @Getter
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private Set<DomicilioDTO> domicilios;
}
