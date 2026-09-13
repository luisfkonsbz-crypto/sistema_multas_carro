package br.edu.ifms.fine_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifms.fine_system.model.Infracao;

public interface Infracoes extends JpaRepository<Infracao, Long> {

}
