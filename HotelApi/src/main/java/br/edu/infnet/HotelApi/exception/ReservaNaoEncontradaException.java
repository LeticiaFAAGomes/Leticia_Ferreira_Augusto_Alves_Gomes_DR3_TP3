package br.edu.infnet.HotelApi.exception;

public class ReservaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ReservaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
