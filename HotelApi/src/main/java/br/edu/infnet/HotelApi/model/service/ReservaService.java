package br.edu.infnet.HotelApi.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.HotelApi.exception.DadosInvalidosException;
import br.edu.infnet.HotelApi.exception.ReservaNaoEncontradaException;
import br.edu.infnet.HotelApi.model.domain.Reserva;

@Service
public class ReservaService {
	
	private final Map<Integer, Reserva> mapaReserva = new HashMap<Integer, Reserva>();
	private final AtomicInteger nextId = new AtomicInteger(1);

	public List<Reserva> obterLista() {
		
		for (Reserva reserva: mapaReserva.values()) {
        	System.out.println("# " + reserva);
        }
		
		return new ArrayList<Reserva>(mapaReserva.values());
	}
	
	public Reserva incluir(Reserva reserva) {
		
		if (reserva.getTitular() == null) {
			throw new DadosInvalidosException("[Erro] O titular da reserva está nulo.");
		}
		
		reserva.setId(nextId.getAndIncrement());
		mapaReserva.put(reserva.getId(), reserva);
		
		return reserva;
	}
	
	public Optional<Reserva> obterPorId(Integer id) {
		
		if (!mapaReserva.containsKey(id)) {
			throw new ReservaNaoEncontradaException("[Erro] Reserva de ID " + id + " não encontrada.");
		}
		
		return Optional.ofNullable(mapaReserva.get(id));
	}
	
	public void excluir(Integer id) {
		
		if (!mapaReserva.containsKey(id)) {
			throw new ReservaNaoEncontradaException("[Erro] Reserva de ID " + id + " não encontrada.");
		}
		
		mapaReserva.remove(id);
	}
	
	public Reserva alterar(Integer id, Reserva reservaAlterada) {
		
		if (!mapaReserva.containsKey(id)) {
			throw new ReservaNaoEncontradaException("[Erro] Dados incorretos " + id + " não encontrada.");
		}
		
		if (reservaAlterada.getTitular() == null) {
			throw new DadosInvalidosException("[Erro] O titular da reserva está nulo.");
		}
		
		reservaAlterada.setId(id);
		mapaReserva.put(reservaAlterada.getId(), reservaAlterada);
		
		return reservaAlterada;
	}
}
