package com.ctd.finalbackend1.unittests.service;

import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.service.implementation.PacienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;
    @Mock
    IPacienteRepository pacienteRepository;

    @Test
    public void añadirPacienteTest() {
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        Mockito.when(pacienteRepository.save(Mockito.any(Paciente.class))).thenReturn(paciente);


        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        Optional<PacienteDTO> pacienteDTO1 = pacienteService.agregar(pacienteDTO);


        assert(pacienteDTO1.isPresent());
        assert(pacienteDTO1.get().getNombre().equals("Juan"));
    }
    @Test
    public void getAllPatients() {
        Mockito.when(pacienteRepository.findAll()).thenReturn(new ArrayList<Paciente>());


        assert(pacienteService.buscarTodos().isEmpty());
        assert(pacienteService.buscarTodos().getClass().equals(HashSet.class));
    }
}
