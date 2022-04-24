package com.ctd.finalbackend1.integrationtests.tests;

import com.ctd.finalbackend1.components.DataLoader;
import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.model.DTO.PacienteDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.model.entity.Paciente;
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

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PacienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void añadirDomicilio() throws Exception {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle");
        Paciente paciente = new Paciente();
        paciente.setId(DataLoader.PACIENTE_ID);
        domicilio.setPaciente(paciente);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/{id}/domicilio", DataLoader.PACIENTE_ID)
                .contentType("application/json")
                .content(mapper.writeValueAsString(domicilio)))
                .andReturn();

        Optional<String> response = mapper.convertValue(mvcResult.getResponse().getContentAsString(), Optional.class);
        DomicilioDTO domicilioDTO = mapper.readValue(response.get(), DomicilioDTO.class);

        assert (mvcResult.getResponse().getStatus() == 200);
        assert(domicilioDTO.getId() != null);
        assert(domicilioDTO.getCalle().equals(domicilio.getCalle()));
        assert(domicilioDTO.getPaciente().getId().equals(domicilio.getPaciente().getId()));
    }

    @Test
    public void actualizarDomicilio() throws Exception {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(DataLoader.DOMICILIO_ID);
        domicilioDTO.setCalle("test");
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(DataLoader.PACIENTE_ID);
        domicilioDTO.setPaciente(pacienteDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/pacientes/{id}/domicilio", DataLoader.PACIENTE_ID)
                        .content(mapper.writeValueAsString(domicilioDTO))
                        .contentType("application/json")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", DataLoader.PACIENTE_ID)
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Optional<String> response = mapper.convertValue(result.getResponse().getContentAsString(), Optional.class);
        PacienteDTO pacienteDTO1 = mapper.readValue(response.get(), PacienteDTO.class);



        pacienteDTO1.getDomicilios().forEach(domicilio -> {
            if(domicilio.getId().equals(DataLoader.DOMICILIO_ID)) {
                assert(domicilio.getCalle().equals(domicilioDTO.getCalle()));
            }
        });
    }
}
