package br.edu.infnet.HotelApi.model.domain;

import java.time.LocalDateTime;

public class Reserva {
	
	private Integer id;
	private String titular;
	private int numeroQuarto;
	private TipoReserva tipoReserva;
	private boolean ehAtiva;
	private LocalDateTime checkIn;
	private double valorTotal;

	public Reserva() {}
	
	public Reserva(Integer id, LocalDateTime checkIn, boolean status) {
		setId(id);
		setCheckIn(checkIn);
		setEhAtiva(status);
	}
	
	public Reserva(String titular, int idadeTitular, TipoReserva tipo,  boolean status, LocalDateTime checkIn, double valorTotal) {
		setTitular(titular);
		setNumeroQuarto(idadeTitular);
		setTipoReserva(tipo);
		setEhAtiva(status);
		setCheckIn(checkIn);
		setValorTotal(valorTotal);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int idadeTitular) {
		this.numeroQuarto = idadeTitular;
	}

	public TipoReserva getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(TipoReserva tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public boolean isEhAtiva() {
		return ehAtiva;
	}

	public void setEhAtiva(boolean ehAtiva) {
		this.ehAtiva = ehAtiva;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override 
	public String toString() {
		return String.format("[Reserva %s]\nTitular %s\nTipo: %s\nCheck-in: %s\nValor Total: R$ %.2f\nReserva Ativa = %s", 
				this.getId(), this.getTitular(),
				this.getTipoReserva(),this.getCheckIn(), 
				this.getValorTotal(),this.isEhAtiva()
		);
	}
}
