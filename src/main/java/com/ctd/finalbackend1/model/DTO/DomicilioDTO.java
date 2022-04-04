package com.ctd.finalbackend1.model.DTO;


import com.ctd.finalbackend1.model.ADTO;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DomicilioDTO extends ADTO {
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
