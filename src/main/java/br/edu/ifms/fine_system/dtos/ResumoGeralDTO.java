package br.edu.ifms.fine_system.dtos;

public record ResumoGeralDTO(String placa, long totalMultas, long pagas, long pendentes, double valorTotal,
		double valorPago, double valorDevido, int totalPontos) {
}
