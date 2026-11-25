package br.edu.ifms.fine_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifms.fine_system.model.Multa;
import java.util.List;

public interface Multas extends JpaRepository<Multa, Long> {
	
    List<Multa> findByCarroId(Long carroId);

    List<Multa> findByCarroPlacaOrderByAnoDesc(String placa);

    List<Multa> findByCarroPlacaIgnoreCaseOrderByAnoDesc(String placa);
}