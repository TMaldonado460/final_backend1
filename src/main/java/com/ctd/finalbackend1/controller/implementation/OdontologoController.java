package com.ctd.finalbackend1.controller.implementation;

import com.ctd.finalbackend1.controller.AController;
import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.service.IService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin("http://localhost:3000")
public class OdontologoController extends AController<IService<OdontologoDTO>, OdontologoDTO> { }
