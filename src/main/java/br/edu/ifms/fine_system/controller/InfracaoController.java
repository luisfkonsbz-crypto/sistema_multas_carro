package br.edu.ifms.fine_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifms.fine_system.model.Infracao;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InfracaoController {

	@GetMapping("/infracoes")
	public ModelAndView ListarInfracoes() {
		ModelAndView mv = new ModelAndView("ListaInfracoes");
		mv.addObject("infracoes", listarInfracoes());
		return mv;
	}
	
	public List<Infracao> listarInfracoes() {
		// Implementar lógica para listar infrações
		List<Infracao> infracoes = new ArrayList<>();
		infracoes.add(new Infracao("Speed Excess", 4, 150.0));
		infracoes.add(new Infracao("Red Light Violation", 3, 200.0));
		return infracoes;
	}

}
