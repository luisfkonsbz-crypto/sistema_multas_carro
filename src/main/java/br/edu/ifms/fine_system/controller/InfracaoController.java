package br.edu.ifms.fine_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifms.fine_system.model.Infracao;
import br.edu.ifms.fine_system.repository.Infracoes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InfracaoController {
	
	@Autowired
	private Infracoes infracoes;

	@GetMapping("/infracoes")
	public ModelAndView ListarInfracoes() {
		ModelAndView mv = new ModelAndView("ListaInfracoes");
		mv.addObject("infracoes", listarInfracoes());
		mv.addObject("infracoesDB", infracoes.findAll());
		return mv;
	}
	
	public List<Infracao> listarInfracoes() {
		// Implementar lógica para listar infrações
		List<Infracao> infracoes = new ArrayList<>();
		infracoes.add(new Infracao(3L, "Excesso de velocidade", 5, 150.0));
		infracoes.add(new Infracao(4L, "Estacionamento proibido", 3, 100.0));
		return infracoes;
	}

}
