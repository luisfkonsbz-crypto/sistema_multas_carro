package br.edu.ifms.fine_system.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Multa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ano;
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "carro_id")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name = "infracao_id")
	private Infracao infracao;
	
	public Multa() {
	}
	
	public Multa(Long id, String ano, String cidade, Carro carro, Infracao infracao) {
		this.id = id;
		this.ano = ano;
		this.cidade = cidade;
		this.carro = carro;
		this.infracao = infracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}
	
	
	
}
