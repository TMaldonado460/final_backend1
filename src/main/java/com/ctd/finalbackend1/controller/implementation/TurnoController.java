package com.ctd.finalbackend1.controller.implementation;


import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.ctd.finalbackend1.service.IService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController extends AController<IService<TurnoDTO>, TurnoDTO> { }
