package com.ctd.finalbackend1.model;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DomicilioDTO {
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
