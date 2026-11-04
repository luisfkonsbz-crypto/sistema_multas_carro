package br.edu.ifms.fine_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.fine_system.model.Multa;
import br.edu.ifms.fine_system.repository.Multas;

@Service
public class MultaService {
	@Autowired
	private Multas multas;
	
	public void deletar(Long id) {
		multas.deleteById(id);
	}
	
	public List<Multa> buscarTodos(){
		return multas.findAll();
	}
	
	public Multa salvar(Multa multa) {
		return multas.save(multa);
	}
	
	public Multa procurar(Long id) {
		return multas.findById(id).orElse(null);
	}

}
