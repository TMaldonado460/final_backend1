package com.ctd.finalbackend1.model.DTO;

import com.ctd.finalbackend1.model.ADTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
public class DomicilioDTO extends ADTO {
    private UUID id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    private Boolean principal;

    @JsonIncludeProperties({"id"})
    private PacienteDTO paciente;
}
