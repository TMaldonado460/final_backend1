package com.ctd.finalbackend1.integrationtests.configuration;


import com.ctd.finalbackend1.repository.IPacienteRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application-test.properties")
@Profile("integration_test")
/*
* En el caso de los test de integracion usare h2 como base de datos,
* tratando de minimizar las posibilidades de errores en la capa de persistencia.
* */
// al final no uso esto, me trae problemas con ciertos beans, no quiero preocuparme, pero la solucion
// seria implementar beans de MockMvc ? algo mas?
public class IntegrationTestConfig {

}
