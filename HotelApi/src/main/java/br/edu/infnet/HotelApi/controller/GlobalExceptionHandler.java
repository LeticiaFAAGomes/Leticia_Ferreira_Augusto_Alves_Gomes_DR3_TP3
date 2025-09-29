package br.edu.infnet.HotelApi.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.infnet.HotelApi.exception.DadosInvalidosException;
import br.edu.infnet.HotelApi.exception.ReservaNaoEncontradaException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ReservaNaoEncontradaException.class)
	public ResponseEntity<Object> handlerReservaNaoEncontradaException(ReservaNaoEncontradaException ex) {
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.NOT_FOUND.value());
		body.put("mensagem", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DadosInvalidosException.class)
	public ResponseEntity<Object> handlerdadosInvalidosException(DadosInvalidosException ex) {
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("mensagem", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
