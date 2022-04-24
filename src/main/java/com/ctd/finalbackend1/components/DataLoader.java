package com.ctd.finalbackend1.components;

import com.ctd.finalbackend1.model.entity.Domicilio;
import com.ctd.finalbackend1.model.entity.Odontologo;
import com.ctd.finalbackend1.model.entity.Paciente;
import com.ctd.finalbackend1.model.entity.Turno;
import com.ctd.finalbackend1.repository.IDomicilioRepository;
import com.ctd.finalbackend1.repository.IOdontologoRepository;
import com.ctd.finalbackend1.repository.IPacienteRepository;
import com.ctd.finalbackend1.repository.ITurnoRepository;
import com.ctd.finalbackend1.security.entity.UserRoles;
import com.ctd.finalbackend1.security.entity.Usuario;
import com.ctd.finalbackend1.security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
// @Profile("test")
@Profile("default") // unit test mock beans rompen esto
// si se ejecuta con spring menor a 2.1.2 buena suerte

/**
 * DataLoader.java -> Objeto que se ejecuta al iniciar la aplicacion
 * sirve para cargar datos en la base de datos para pruebas
 */
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;
    private IPacienteRepository pacienteRepository;
    private ITurnoRepository turnoRepository;
    private IOdontologoRepository odontologoRepository;
    private IDomicilioRepository domicilioRepository;

    public static UUID ODONTOLOGO_ID;
    public static UUID PACIENTE_ID;
    public static UUID TURNO_ID;
    public static Date FECHA_TURNO = new Date(122, 12, 30);
    public static UUID DOMICILIO_ID;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setPacienteRepository(IPacienteRepository pacienteRepository) { this.pacienteRepository = pacienteRepository; }
    @Autowired
    public void setTurnoRepository(ITurnoRepository turnoRepository) { this.turnoRepository = turnoRepository; }
    @Autowired
    public void setOdontologoRepository(IOdontologoRepository odontologoRepository) { this.odontologoRepository = odontologoRepository; }
    @Autowired
    public void setDomicilioRepository(IDomicilioRepository domicilioRepository) { this.domicilioRepository = domicilioRepository; }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("admin");
        userRepository.save(Usuario.builder().username("admin").password(password).roles(UserRoles.ROLE_ADMIN).build());
        /*
        Paciente paciente = new Paciente(); // tratando de añadir un paciente a un user
        paciente.setNombre("Juan");
        password = encoder.encode("user");
        */
        userRepository.save(Usuario.builder().username("user").password(password).roles(UserRoles.ROLE_USER)/*.paciente(paciente)*/.build());

        Paciente paciente = new Paciente();
        paciente.setNombre("paciente");
        paciente.setId(PACIENTE_ID);
        PACIENTE_ID = pacienteRepository.save(paciente).getId();

        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("odontologo");
        odontologo.setId(ODONTOLOGO_ID);
        ODONTOLOGO_ID = odontologoRepository.save(odontologo).getId();

        Turno turno = new Turno();
        turno.setId(TURNO_ID);
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFecha(FECHA_TURNO);
        TURNO_ID = turnoRepository.save(turno).getId();

        Domicilio domicilio = new Domicilio();
        domicilio.setId(DOMICILIO_ID);
        domicilio.setCalle("calle");
        domicilio.setPaciente(paciente);
        DOMICILIO_ID = domicilioRepository.save(domicilio).getId();
    }


}
