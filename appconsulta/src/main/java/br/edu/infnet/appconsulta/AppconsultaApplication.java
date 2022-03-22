package br.edu.infnet.appconsulta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppconsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppconsultaApplication.class, args);
	}

}
