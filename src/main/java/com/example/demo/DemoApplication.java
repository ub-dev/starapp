package com.example.demo;

//import java.time.LocalDate;
//import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
@EnableWebSecurity
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	 System.out.println("started");
	}
	//@Autowired
	//private UserRepository userRepository;

	/*@Override
   public void run(String... args) throws Exception {
			
		this.userRepository.save(new User("mohini","abc@23","developer","requested",LocalDateTime.now()));
			
		}*/


}
