package com.spring.addressbook.builder;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.spring.addressbook.dto.AddressBookDTO;
import com.spring.addressbook.entity.AddressBookEntity;

@Component
public class AddressBookBuilder 
{
	public AddressBookEntity buildDO(AddressBookDTO dto)
	{
		AddressBookEntity entity = new AddressBookEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
}
