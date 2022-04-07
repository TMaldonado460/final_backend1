package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.service.AService;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService extends AService<Domicilio, DomicilioDTO, IDomicilioRepository> {
    public DomicilioService() {
        super.setDtoClazz(DomicilioDTO.class);
        super.setEntityClass(Domicilio.class);
    }
}
