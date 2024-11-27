package com.agrobyte.ApiMobileAgrobyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiMobileAgrobyteApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ApiMobileAgrobyteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("1"));

		boolean result = passwordEncoder.matches("123456", "$2a$10$Omml9pexRdPud66HtbyBc.NuR2PGooZG0qYjqbeUc7ZYNiVithN22");

		System.out.println("Resultado = " + result);
	}
}