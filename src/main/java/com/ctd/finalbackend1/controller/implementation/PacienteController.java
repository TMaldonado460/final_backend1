package com.ctd.finalbackend1.controller.implementation;

import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.service.IService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/pacientes")
public class PacienteController extends AController<IService<PacienteDTO>, PacienteDTO> { }