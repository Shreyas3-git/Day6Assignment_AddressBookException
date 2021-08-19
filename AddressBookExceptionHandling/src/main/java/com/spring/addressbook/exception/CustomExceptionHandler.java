package com.spring.addressbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.addressbook.dto.ResponseDTO;

@ControllerAdvice
public class CustomExceptionHandler 
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> globalException(Exception exception)
	{
		return new ResponseEntity<>(new ResponseDTO(exception.getMessage(),
		HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDTO> CustomException(Exception exception)
	{
		return new ResponseEntity<>(new ResponseDTO(exception.getMessage(),
		HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
	}
}
