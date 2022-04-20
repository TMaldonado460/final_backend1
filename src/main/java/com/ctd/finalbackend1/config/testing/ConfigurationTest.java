package com.ctd.finalbackend1.config.testing;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("runtime-test") // permite ejecutar los componentes de la aplicacion en un entorno de prueba
@Configuration
@PropertySource("classpath:application-test.properties") // base de datos local
public class ConfigurationTest {
}
