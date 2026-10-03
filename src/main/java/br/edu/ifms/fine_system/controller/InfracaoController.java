package br.edu.ifms.fine_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifms.fine_system.model.Infracao;


import java.util.ArrayList;
import java.util.List;
import br.edu.ifms.fine_system.service.InfracaoService;

@Controller
public class InfracaoController {
	
	@Autowired
	private InfracaoService infracoes;

	@GetMapping("/infracoes")
	public ModelAndView ListarInfracoes() {
		ModelAndView mv = new ModelAndView("ListaInfracoes");
		//mv.addObject("infracoes", listarInfracoes());
		
		mv.addObject("infracoesDB", infracoes.buscarTodos());
		mv.addObject("infracao", new Infracao());
		
		return mv;
	}
	
	public List<Infracao> listarInfracoes() {
		// Implementar lógica para listar infrações
		List<Infracao> infracoes = new ArrayList<>();
		infracoes.add(new Infracao(3L, "Dirigir veiculo segurando/manuseando telefone celular", 7, 293.47));
		infracoes.add(new Infracao(4L, "Estacionar nos acostamentos", 3, 88.38));
		return infracoes;
	}
	
	@GetMapping("/infracoes/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaInfracoes");
		modelAndView.addObject(infracoes.procurar(id));
		return modelAndView;
	}
	
	@GetMapping("/infracoes/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		infracoes.deletar(id);
		return "redirect:/infracoes";
	}
	
	@PostMapping("/infracoes")
	public String salvar(Infracao infracao) {
		infracoes.salvar(infracao);
		return "redirect:/infracoes";
	}

}
