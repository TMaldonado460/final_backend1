package com.ctd.finalbackend1.unittests.configuration;


import com.ctd.finalbackend1.repository.IPacienteRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Profile("test")
@Configuration
@PropertySource("classpath:application-test.properties")
public class TestConfig {
    @Bean
    @Primary
    public IPacienteRepository pacienteRepository() {
        return Mockito.mock(IPacienteRepository.class);
    }
}
