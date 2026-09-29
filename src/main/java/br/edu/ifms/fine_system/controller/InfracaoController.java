package br.edu.ifms.fine_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		infracoes.add(new Infracao(3L, "Dirigir veiculo segurando/manuseando telefone celular", 7, 293.47));
		infracoes.add(new Infracao(4L, "Estacionar nos acostamentos", 3, 88.38));
		return infracoes;
	}
	
	@GetMapping("/infracoes/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaInfracoes");
		modelAndView.addObject(infracoes.findById(id).orElse(null));
		return modelAndView;
	}
	
	@GetMapping("/infracoes/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		infracoes.deleteById(id);
		return "redirect:/infracoes";
	}

}
