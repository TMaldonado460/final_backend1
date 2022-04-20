package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.model.entity.Odontologo;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService extends AService<Odontologo, OdontologoDTO, IOdontologoRepository> {
    public OdontologoService() {
        super.setDtoClazz(OdontologoDTO.class);
        super.setEntityClazz(Odontologo.class);
    }
}
