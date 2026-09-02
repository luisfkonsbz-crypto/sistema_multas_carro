package br.edu.ifms.fine_system.model;

import java.io.Serializable;

public class Infracao implements Serializable {
	String descricao;
	int pontos;
	double valor;
	
	public Infracao(String descricao, int pontos, double valor) {
		this.descricao = descricao;
		this.pontos = pontos;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
