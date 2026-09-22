package br.edu.ifms.fine_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.fine_system.model.Carro;
import br.edu.ifms.fine_system.repository.Carros;

@Service
public class CarroService {

	@Autowired
	private Carros carros;
	
	// CRUD: buscar, salvar, procurar e deletar
	
	public List<Carro> buscarTodos() {
		return carros.findAll();
	}
	
	public Carro salvar(Carro carro) {
		return carros.save(carro);
	}
	
	public Carro procurar(Long id) {
		return carros.findById(id).orElse(null);
	}
	
	public void deletar(Long id) {
		carros.deleteById(id);
	}
}
