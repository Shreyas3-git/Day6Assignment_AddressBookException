package com.spring.addressbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.spring.addressbook.dto.AddressBookDTO;
import com.spring.addressbook.dto.ResponseDTO;
import com.spring.addressbook.entity.AddressBookEntity;
import com.spring.addressbook.service.AddressBookService;

@RestController
public class AddressBookController 
{
	@Autowired
	private AddressBookService service;
	Logger log = LoggerFactory.getLogger(AddressBookController.class);

	/**
	 * getListOfRecords() --> In this function first simply give one logger info level message 
	 * 					next i create list of addressbookEntity this list of reference variable "entity" can hold all record i.e data,
	 * 					which is return by getAllDetails() function in the service class and i call ResponseDTO() parametarised constructor
	 * 					and i am passing parameter as success message and data. 
	 * @return     -->	This function return all the data present in database table and one success code which betn 200-299 
	 */

	@RequestMapping(method = RequestMethod.GET,value = "/retrive")
	public ResponseEntity<ResponseDTO> getListOfRecords()
	{
		log.info("Here, I retrive all the which is currently available on the database table:");
		List<AddressBookEntity> entity = service.getAllDetails();
		ResponseDTO dto = new ResponseDTO("All data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	/**
	 * findById() -->  giving logger info message as data retrived for which id
	 * 				   reference entity can hold specific filed data return by getById function
	 * 				   from the service class.In the ResponseDTO constructor i passed success msg para,entity
	 * 				   which hold the data of perticular filed in the table
	 * @param id  -->  Here id passed for matching record between list of records and return perticular record only 
	 * @return	  -->  This function return success msg and single entity record
	 */

	@RequestMapping(method = RequestMethod.GET,value = "/retrive/{id}")
	public ResponseEntity findById(@PathVariable int id)
	{
		log.info("data will be retrived for id:" + id);
		AddressBookEntity entity = service.getRecordById(id);
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	/**
	 * insertRecord()  -->	 give one logger msg for insert,Here insertRecord function in service class
	 * 					 can return null,in the ResponseDTO constructor passed success msg and entity which points to null 
	 * @param addressbookdto --> i take this dto reference becuz i passed it in service class to AddressBookEntity for calling constructor
	 * @return 				 --> This function return message as "Data added successfully" and return data as null
	 */

	@RequestMapping(method = RequestMethod.POST,value = "/insert")
	public ResponseEntity insertRecord(@RequestBody AddressBookDTO addressbookdto)
	{
		log.info("Inserting data into database table:");
		AddressBookEntity entity = service.addNewRecord(addressbookdto);
		ResponseDTO dto = new ResponseDTO("Data added successfully:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	/**
	 * ModifyRecord()		--> This function update record based on id, logic metioned in service class 
	 * @param addressbookdto --> addressbookdto class reference variable passed to service class method
	 * @param id		     -->This id i take to perform update operation further in service class
	 * @return				 --> This function return message as "Record updated successully:" and return data as null
	 */

	@RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
	public ResponseEntity ModifyRecord(@PathVariable int id,@RequestBody AddressBookDTO addressbookdto)
	{
		log.info("Record updated for id: " + id);
		AddressBookEntity entity = service.updateRecord(id,addressbookdto);
		ResponseDTO dto = new ResponseDTO("Data updated successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	
	/**
	 * removeById()  --> giving logger info message as data deleted for perticular id:
	 * 						   give call to the deleteRecord() function which in the service class
	 * 						   this function return null after deletion.
	 * @param id		   --> I take id as parameter becuz based on id deletion will take place
	 * @return			   --> This function return message "Record deleted successfully:" and data as null
	 */

	@RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
	public ResponseEntity removeById(@PathVariable int id)
	{	
		log.info("Data deleted for Id:" + id);
		AddressBookEntity entity = service.deleteById(id);
		ResponseDTO dto = new ResponseDTO("Data deleted successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
}
