package br.edu.ifms.fine_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifms.fine_system.model.Infracao;

import br.edu.ifms.fine_system.repository.Infracoes;

@Service
public class InfracaoService {
	
	@Autowired
	private Infracoes infracoes;
	
	public void deletar(Long id) {
		infracoes.deleteById(id);
	}
	
	public List<Infracao> buscarTodos(){
		return infracoes.findAll();
	}

}
