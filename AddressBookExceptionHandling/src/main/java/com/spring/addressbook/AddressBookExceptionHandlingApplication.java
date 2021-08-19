package com.spring.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AddressBookExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookExceptionHandlingApplication.class, args);
	}

}
