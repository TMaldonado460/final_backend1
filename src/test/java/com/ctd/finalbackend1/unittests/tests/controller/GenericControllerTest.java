/*package com.ctd.finalbackend1.unittests.tests.controller;
 TODO : # no pude resolver problemas de beans, multiples beans de odontologo service, y tira problemas en el controller cuando corro la aplicacion
 TODO : # cuando tenga mas tiempo me ponde a buscar cual es la solucion para esto, sin embargo hasta entonces no puedo hacer
 TODO : # pruebas unitarias para los controllers



import com.ctd.finalbackend1.controller.implementation.OdontologoController;
import com.ctd.finalbackend1.model.DTO.OdontologoDTO;
import com.ctd.finalbackend1.service.implementation.OdontologoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.UUID;

@RunWith(JUnit4.class)
@ActiveProfiles("unit_test_controller")
public class GenericControllerTest {
    // todos los controllers son hijos de una clase abstracta que implementa los metodos
    // dados como generics un service y un dto
    // es el perfecto candidato para testear la clase abstracta
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private OdontologoController odontologoController = new OdontologoController(odontologoService);



    // TODO: implementar los test de los controllers
    //buscarPorId(id)
    //buscarTodos()
    //crear(dto)
    //actualizar(dto)
    //borrar(id) <- not found

    @Test
    public void buscarPorId() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("nombre");
        Mockito.when(odontologoService.buscarPorId(Mockito.any(UUID.class))).thenReturn(Optional.of(odontologoDTO));

        ResponseEntity<Optional<OdontologoDTO>> responseEntity = odontologoController.buscarPorId(UUID.randomUUID());

        Mockito.verify(odontologoService, Mockito.times(1)).buscarPorId(Mockito.any(UUID.class));
        assert responseEntity.getStatusCode().is2xxSuccessful();
        assert responseEntity.getBody().get().getNombre().equals("nombre");
    }
}


 */