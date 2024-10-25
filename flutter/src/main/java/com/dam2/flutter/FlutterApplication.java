package com.dam2.flutter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan

public class FlutterApplication {

	public static void main(String[] args) {
		//iniciar aplicacion
		SpringApplication.run(FlutterApplication.class, args);
	}
}
