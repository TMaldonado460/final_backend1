package com.ctd.finalbackend1.unittests.tests.service;

import com.ctd.finalbackend1.model.DTO.DomicilioDTO;
import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.service.implementation.DomicilioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("unit_test_service")
public class DomicilioServiceTest {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    private DomicilioService domicilioService;


    @Test
    public void persistirDomicilio(){
        UUID id = UUID.randomUUID();
        Mockito.when(domicilioRepository.save(Mockito.any(Domicilio.class))).thenAnswer(invocation -> {
            Domicilio domicilioArg = invocation.getArgument(0);
            domicilioArg.setId(id);
            return domicilioArg;
        });

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("calle");
        DomicilioDTO response = domicilioService.guardar(domicilioDTO).get();

        assert response.getId().equals(id);
        assert response.getCalle().equals("calle");
    }
}
