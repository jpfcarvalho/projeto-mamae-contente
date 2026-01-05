package com.projeto.mamaecontente;

import org.springframework.boot.SpringApplication;

public class TestMamaeContenteApplication {

	public static void main(String[] args) {
		SpringApplication.from(MamaeContenteApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
