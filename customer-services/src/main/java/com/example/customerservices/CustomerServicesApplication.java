package com.example.customerservices;

import com.example.customerservices.model.Customer;
import com.example.customerservices.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServicesApplication.class, args);
	}
	@Bean
	CommandLineRunner run (CustomerRepository customerRepository) {

		return args -> {
			customerRepository.save(new Customer(1,"ahmad"));
			customerRepository.save(new Customer(2,"faisal"));
			customerRepository.save(new Customer(3,"nora"));
			customerRepository.save(new Customer(4,"youseef"));
		};
	}

}
