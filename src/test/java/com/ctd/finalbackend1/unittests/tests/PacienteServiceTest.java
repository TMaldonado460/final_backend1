package com.ctd.finalbackend1.unittests.tests;

import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
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

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
public class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;
    @Autowired
    IPacienteRepository pacienteRepository;

    @Test
    public void añadirNuevoPaciente() {
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
    public void borrarPacienteConId() {
        pacienteService.eliminar(new UUID(0,0));
        Mockito.verify(pacienteRepository, Mockito.times(1)).deleteById(Mockito.any(UUID.class));
    }



    @Test
    public void getAllPatients() {
        Mockito.when(pacienteRepository.findAll()).thenReturn(new ArrayList<Paciente>());

        assert(pacienteService.buscarTodos().isEmpty());
        assert(pacienteService.buscarTodos().getClass().equals(HashSet.class));
    }

    @Test
    public void actualizarPacienteTest() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");

        pacienteService.actualizar(pacienteDTO);

        Mockito.verify(pacienteRepository, Mockito.times(1)).save(Mockito.any(Paciente.class));
    }

    @Test
    public void buscarPorIdTest() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        pacienteDTO.setId(new UUID(0,0));

        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setId(new UUID(0,0));

        Mockito.when(pacienteRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(paciente));

        assert(pacienteService.buscarPorId(new UUID(0,0)).isPresent());
        assert(pacienteService.buscarPorId(new UUID(0,0)).get().getNombre().equals("Juan"));
    }

    @Test
    public void guardarPacienteInsertarPacienteEnDomicilioTest() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Juan");
        Set<DomicilioDTO> domicilios = new HashSet<>();
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Calle");
        pacienteDTO.setDomicilios(domicilios);

        Mockito.when(pacienteRepository.save(Mockito.any(Paciente.class))).thenAnswer(invocation -> {
            Paciente paciente = invocation.getArgument(0);
            return paciente;
        });

        PacienteDTO paciente = pacienteService.agregar(pacienteDTO).get();

        for (DomicilioDTO domicilio : paciente.getDomicilios()) {
            assert(domicilio.getPaciente().equals(paciente));
        }
    }
}
