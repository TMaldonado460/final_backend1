package com.ctd.finalbackend1.integrationtests.configuration;


import com.ctd.finalbackend1.repository.IPacienteRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application-test.properties")
public class IntegrationTestConfig {
}
