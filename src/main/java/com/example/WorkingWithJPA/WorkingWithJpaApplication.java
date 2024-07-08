package com.example.WorkingWithJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.WorkingWithJPA")
public class WorkingWithJpaApplication {

	private static final Logger log = 
	LoggerFactory.getLogger(WorkingWithJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkingWithJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return (args) ->{
			repository.save(new Customer(null,"Ian", "Gatitu"));
			repository.save(new Customer(null,"John", "Doe"));
			repository.save(new Customer(null,"Chepkorir", "Her"));
			repository.save(new Customer(null,"Chebet", "Her"));

			repository.findAll().forEach(customer->{
				log.info(customer.toString());
			});
			
			log.info("");

			Customer customer = repository.findById(1L);

			log.info(customer.toString());

			repository.findByLastName("Her").forEach(Her ->{
				log.info(Her.toString());
			});
		};
	}



}
