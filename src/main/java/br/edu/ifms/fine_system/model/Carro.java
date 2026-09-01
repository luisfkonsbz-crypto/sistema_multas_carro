package br.edu.ifms.fine_system.model;

import java.io.Serializable;

public class Carro implements Serializable {
	private Long id;
	private String placa;

	public Carro() {
	}

	public Carro(Long id, String modelo, String placa, String cor) {
		this.id = id;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
