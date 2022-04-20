package com.ctd.finalbackend1.model.DTO;

import com.ctd.finalbackend1.model.ADTO;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
public class OdontologoDTO extends ADTO {
    private UUID id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
