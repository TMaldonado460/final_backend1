package com.ctd.finalbackend1.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class OdontologoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
