package com.ctd.finalbackend1.security.component;

import com.ctd.finalbackend1.security.entity.UserRoles;
import com.ctd.finalbackend1.security.entity.Usuario;
import com.ctd.finalbackend1.security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("admin");
        userRepository.save(Usuario.builder().username("admin").password(password).roles(UserRoles.ROLE_ADMIN).build());

        password = encoder.encode("user");
        userRepository.save(Usuario.builder().username("user").password(password).roles(UserRoles.ROLE_USER).build());
    }
}
