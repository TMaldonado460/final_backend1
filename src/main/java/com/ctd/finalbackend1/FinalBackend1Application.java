package com.ctd.finalbackend1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
// porque estamos testeando aplicamos el profile de test

public class FinalBackend1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalBackend1Application.class, args);
	}

}
