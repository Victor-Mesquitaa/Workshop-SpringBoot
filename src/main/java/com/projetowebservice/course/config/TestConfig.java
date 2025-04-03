package com.projetowebservice.course.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservice.course.entities.User;
import com.projetowebservice.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
			
		User u1 = new User(null, "Rodrigo Garro", "garro@gmail.com", "987456321", "102030");
		User u2 = new User(null, "Igor Coronado", "coronado@gmail.com", "965412389", "051015");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
