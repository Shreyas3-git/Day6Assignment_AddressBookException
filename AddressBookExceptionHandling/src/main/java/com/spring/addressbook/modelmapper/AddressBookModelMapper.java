package com.spring.addressbook.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class AddressBookModelMapper 
{
	@Bean
	public ModelMapper addModelMapper()
	{
		return new ModelMapper();
	}
}
