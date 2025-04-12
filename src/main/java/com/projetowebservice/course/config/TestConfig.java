package com.projetowebservice.course.config;

import java.sql.Array;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservice.course.entities.Category;
import com.projetowebservice.course.entities.Order;
import com.projetowebservice.course.entities.Product;
import com.projetowebservice.course.entities.User;
import com.projetowebservice.course.entities.enums.OrderStatus;
import com.projetowebservice.course.repositories.CategoryRepository;
import com.projetowebservice.course.repositories.OrderRepository;
import com.projetowebservice.course.repositories.ProductRepository;
import com.projetowebservice.course.repositories.UserRepository;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Games");
		Category cat3 = new Category(null, "Computers & Tablets");
		
		Product p1 = new Product(null, "Call of Duty", "War, blood and guns", 40.0, "");
		Product p2 = new Product(null, "Smart TV", "Buy this TV for watch your series", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Your future needs a Macbook", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "'This is just for study'", 1200.0, "");
		Product p5 = new Product(null, "Fifa 25", "You'll have headache in this game", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Rodrigo Garro", "garro@gmail.com", "987456321", "102030");
		User u2 = new User(null, "Igor Coronado", "coronado@gmail.com", "965412389", "051015");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
 		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
 		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
