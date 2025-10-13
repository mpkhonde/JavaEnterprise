package se.projektarbete.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // markerar startpunkten för hela Spring Boot-projektet
public class StudentApiApplication {

	public static void main(String[] args) {
		// startar applikationen skapar Spring konststen och kör servern
		SpringApplication.run(StudentApiApplication.class, args);
	}
}
