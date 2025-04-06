package com.projetowebservice.course.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservice.course.entities.Order;
import com.projetowebservice.course.entities.User;
import com.projetowebservice.course.repositories.OrderRepository;
import com.projetowebservice.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
			
		User u1 = new User(null, "Rodrigo Garro", "garro@gmail.com", "987456321", "102030");
		User u2 = new User(null, "Igor Coronado", "coronado@gmail.com", "965412389", "051015");
		
		Order o1 = new Order(null, Instant.parse("2025-04-01T19:30:00Z"), u1);
		Order o2 = new Order(null, Instant.parse("2025-03-30T03:10:00Z"), u2);
		Order o3 = new Order(null, Instant.parse("2025-04-06T15:20:00Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
