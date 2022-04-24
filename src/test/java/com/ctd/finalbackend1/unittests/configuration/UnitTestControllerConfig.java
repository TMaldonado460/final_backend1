package com.ctd.finalbackend1.unittests.configuration;


import com.ctd.finalbackend1.service.implementation.OdontologoService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Profile("unit_test_controller")
@Configuration
@PropertySource("classpath:application-test.properties")
public class UnitTestControllerConfig {
    @Bean
    @Primary
    public OdontologoService odontologoService() {
        return Mockito.mock(OdontologoService.class);
    } // esto me tira problemas con beans de tipo @Autowired
}
