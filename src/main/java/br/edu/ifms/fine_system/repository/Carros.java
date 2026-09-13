package br.edu.ifms.fine_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.fine_system.model.Carro;

public interface Carros extends JpaRepository<Carro, Long> {

}
