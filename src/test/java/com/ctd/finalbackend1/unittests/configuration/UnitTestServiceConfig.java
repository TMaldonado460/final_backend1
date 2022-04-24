package com.ctd.finalbackend1.unittests.configuration;


import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Profile("unit_test_service")
@Configuration
@PropertySource("classpath:application-test.properties")
public class UnitTestServiceConfig {
    @Bean
    @Primary
    public IPacienteRepository pacienteRepository() {
        return Mockito.mock(IPacienteRepository.class);
    }

    @Bean
    @Primary
    public IOdontologoRepository odontologoRepository() {
        return Mockito.mock(IOdontologoRepository.class);
    }

    @Bean
    @Primary
    public ITurnoRepository turnoRepository() {
        return Mockito.mock(ITurnoRepository.class);
    }

    @Bean
    @Primary
    public IDomicilioRepository domicilioRepository() { return Mockito.mock(IDomicilioRepository.class); }
}
