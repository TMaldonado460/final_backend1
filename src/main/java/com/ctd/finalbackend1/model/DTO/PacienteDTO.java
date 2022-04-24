package com.ctd.finalbackend1.model.DTO;

import com.ctd.finalbackend1.model.ADTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Setter @Getter
public class PacienteDTO extends ADTO {
    private UUID id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    //@JsonIgnore
    private Set<DomicilioDTO> domicilios;
    /*
    private DomicilioDTO domicilioActual;


    public void setDomicilios(Set<DomicilioDTO> domicilios) {
        domicilioActual = domicilios.stream().filter(domicilio -> domicilio.getPrincipal()).findAny().orElse(null);
    }
     */
}
