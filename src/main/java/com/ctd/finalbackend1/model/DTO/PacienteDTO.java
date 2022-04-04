package com.ctd.finalbackend1.model.DTO;

import com.ctd.finalbackend1.model.ADTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter @Getter
public class PacienteDTO extends ADTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private Set<DomicilioDTO> domicilios;
}
