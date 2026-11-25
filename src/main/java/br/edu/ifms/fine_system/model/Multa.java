package br.edu.ifms.fine_system.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

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

	@Column(name = "paga")
    private Boolean paga = false;

    @Column(name = "valor_pago")
    private Double valorPago = 0.0;

    @Column(name = "data_pagamento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;

    public Multa() {}

    public Multa(Long id, Carro carro, String ano, String cidade, Infracao infracao,
                 Boolean paga, Double valorPago, LocalDate dataPagamento) {
        this.id = id;
        this.carro = carro;
        this.ano = ano;
        this.cidade = cidade;
        this.infracao = infracao;
        this.paga = paga != null ? paga : false;
        this.valorPago = valorPago != null ? valorPago : 0.0;
        this.dataPagamento = dataPagamento;
    }

    @Transient
    public Double getValorInfracao() {
        return (infracao != null) ? infracao.getValor() : 0.0;
    }


    @Transient
    public Double getValorDevido() {
        double pago = (valorPago != null) ? valorPago : 0.0;
        double devido = getValorInfracao() - pago;
        return Math.max(0.0, devido);
    }

    @Transient
    public String getSituacao() {
        return Boolean.TRUE.equals(paga) ? "Paga" : "Pendente";
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

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
}
