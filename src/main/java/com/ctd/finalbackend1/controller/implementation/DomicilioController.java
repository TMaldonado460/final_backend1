package com.ctd.finalbackend1.controller.implementation;


import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.service.IService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController extends AController<IService<DomicilioDTO>, DomicilioDTO> { }
