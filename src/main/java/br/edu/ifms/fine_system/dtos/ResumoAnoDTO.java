package br.edu.ifms.fine_system.dtos;

public record ResumoAnoDTO(Integer ano, long quantidade, double valorTotal, double valorPago, double valorDevido,
		int pontos) {
}
