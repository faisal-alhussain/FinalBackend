package com.example.itemservices;

import com.example.customerservices.EnableEurekaClient;
import com.example.itemservices.model.Customer;
import com.example.itemservices.model.Item;
import com.example.itemservices.repository.CustomerRepository;
import com.example.itemservices.repository.ItemRepository;
import com.example.itemservices.service.impl.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient

public class ItemServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ItemRepository itemRepository, ItemService itemService, CustomerRepository customerRepository) {
		return args -> {

			itemRepository.save(new Item("games","toy",20,2,null));
			itemRepository.save(new Item("table","Chair",30,3,null));
			itemRepository.save(new Item("game","Xbox",1000,1,null));
			itemService.getItemById("game");
			itemService.updateItemPrice(50,"game");


		};
	}
}