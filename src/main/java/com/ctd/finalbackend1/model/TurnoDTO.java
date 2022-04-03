package com.ctd.finalbackend1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class TurnoDTO {
    private Integer id;
    private Date fecha;
    @JsonIgnoreProperties({"nombre"})
    private OdontologoDTO odontologo;
    @JsonIgnoreProperties({"dni", "fechaIngreso", "domicilios"})
    private PacienteDTO paciente;
}
