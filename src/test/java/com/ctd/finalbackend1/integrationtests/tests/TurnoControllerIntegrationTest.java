package com.ctd.finalbackend1.integrationtests.tests;

import com.ctd.finalbackend1.components.DataLoader;
import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.DTO.TurnoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TurnoControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testPostTurno() throws Exception {
        TurnoDTO turnoDTO = new TurnoDTO();
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(DataLoader.PACIENTE_ID);
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(DataLoader.ODONTOLOGO_ID);

        turnoDTO.setPaciente(pacienteDTO);
        turnoDTO.setOdontologo(odontologoDTO);
        turnoDTO.setFecha(new Date(122, 1, 1));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                .contentType("application/json")
                .content(mapper.writeValueAsString(turnoDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        Optional<String> response = mapper.convertValue(result.getResponse().getContentAsString(), Optional.class);
        TurnoDTO turnoResponse = mapper.readValue(response.get(), TurnoDTO.class);

        assert(turnoResponse.getId() != null);
        assert(turnoResponse.getFecha().equals(turnoDTO.getFecha()));
    }

    @Test
    public void testPostTurnoConFechaAnteriormentePersistidaEnPaciente() throws Exception {
        TurnoDTO turnoDTO = new TurnoDTO();
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(DataLoader.PACIENTE_ID);
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(DataLoader.ODONTOLOGO_ID);

        turnoDTO.setPaciente(pacienteDTO);
        turnoDTO.setOdontologo(odontologoDTO);
        turnoDTO.setFecha(DataLoader.FECHA_TURNO);

        mockMvc.perform(MockMvcRequestBuilders.post("/turnos")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(turnoDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void traerTurnosDeOdontologo() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/odontologo/{id}", DataLoader.ODONTOLOGO_ID))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Optional<String> response = mapper.convertValue(result.getResponse().getContentAsString(), Optional.class);
        TurnoDTO[] turnosResponse = mapper.readValue(response.get(), TurnoDTO[].class);

        assert(turnosResponse.length != 0);
    }

    @Test
    public void traerTurnosDePaciente() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/paciente/{id}", DataLoader.PACIENTE_ID))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Optional<String> response = mapper.convertValue(result.getResponse().getContentAsString(), Optional.class);
        TurnoDTO[] turnosResponse = mapper.readValue(response.get(), TurnoDTO[].class);

        assert(turnosResponse.length != 0);
    }

}
