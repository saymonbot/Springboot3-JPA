package com.saymon.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.saymon.course.entities.Category;
import com.saymon.course.entities.Order;
import com.saymon.course.entities.OrderItem;
import com.saymon.course.entities.Payment;
import com.saymon.course.entities.Product;
import com.saymon.course.entities.User;
import com.saymon.course.entities.enums.OrderStatus;
import com.saymon.course.repositories.CategoryRepository;
import com.saymon.course.repositories.OrderItemRepository;
import com.saymon.course.repositories.OrderRepository;
import com.saymon.course.repositories.ProductRepository;
import com.saymon.course.repositories.UserRepository;

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
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product prod1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product prod2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product prod3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product prod4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product prod5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		prod1.getCategories().add(cat2);
		prod2.getCategories().add(cat3);
		prod2.getCategories().add(cat1);
		prod3.getCategories().add(cat3);
		prod4.getCategories().add(cat3);
		prod5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMMENT, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMMENT, user1); 
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		OrderItem orderItem1 = new OrderItem(order1, prod1, 2, prod1.getPrice());
		OrderItem orderItem2 = new OrderItem(order1, prod3, 1, prod3.getPrice());
		OrderItem orderItem3 = new OrderItem(order2, prod3, 2, prod3.getPrice());
		OrderItem orderItem4 = new OrderItem(order3, prod5, 2, prod5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(I, orderItem2, orderItem3, orderItem4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(pay1);
		
		orderRepository.save(order1);
	}
}