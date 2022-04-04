package com.ctd.finalbackend1.service.implementation;

import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService extends AService<Domicilio, DomicilioDTO, IDomicilioRepository> { }
