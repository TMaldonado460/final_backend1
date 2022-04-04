package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import org.springframework.stereotype.Service;

@Service
public class TurnoService extends AService<Turno, TurnoDTO, ITurnoRepository> { }
