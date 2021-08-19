package com.spring.addressbook.service;

import java.util.List;

import com.spring.addressbook.dto.AddressBookDTO;
import com.spring.addressbook.entity.AddressBookEntity;
public interface IAddressBookService 
{
	public abstract List<AddressBookEntity> getAllDetails();
	public abstract AddressBookEntity getRecordById(int id);
	public abstract AddressBookEntity addNewRecord(AddressBookDTO dto);
	public abstract AddressBookEntity updateRecord(int id, AddressBookDTO dto);
	public abstract AddressBookEntity deleteById(int id);
}
