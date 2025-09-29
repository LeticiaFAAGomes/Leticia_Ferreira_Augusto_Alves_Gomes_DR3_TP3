package br.edu.infnet.HotelApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.HotelApi.model.domain.Reserva;
import br.edu.infnet.HotelApi.model.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
	
	private final ReservaService reservaService;
	
	public ReservaController(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Reserva>> obterLista() {
		
		List<Reserva> lista = reservaService.obterLista();
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Reserva> incluir(@RequestBody Reserva reserva) {
		Reserva novaReserva = reservaService.incluir(reserva);
	
		return new ResponseEntity<Reserva>(novaReserva, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Reserva>> obterPorId(@PathVariable int id) {
		
		Optional<Reserva> reservaEncontrada = reservaService.obterPorId(id);
		
	    return new ResponseEntity<Optional<Reserva>>(reservaEncontrada, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		
		reservaService.excluir(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
		 
	@PutMapping("/{id}")
	public ResponseEntity<Reserva> alterar(@PathVariable Integer id, @RequestBody Reserva reserva) {
		
		Reserva reservaAlterada = reservaService.alterar(id, reserva);
		
		return new ResponseEntity<Reserva>(reservaAlterada, HttpStatus.OK);
		
	}
}
