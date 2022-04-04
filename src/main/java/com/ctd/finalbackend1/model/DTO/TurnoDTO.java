package com.ctd.finalbackend1.model.DTO;

import com.ctd.finalbackend1.model.ADTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class TurnoDTO extends ADTO {
    private Integer id;
    private Date fecha;
    @JsonIgnoreProperties({"nombre"})
    private OdontologoDTO odontologo;
    @JsonIgnoreProperties({"dni", "fechaIngreso", "domicilios"})
    private PacienteDTO paciente;
}
