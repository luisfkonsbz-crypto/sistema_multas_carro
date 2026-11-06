package br.edu.ifms.fine_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.fine_system.model.Multa;
import br.edu.ifms.fine_system.service.CarroService;
import br.edu.ifms.fine_system.service.InfracaoService;
import br.edu.ifms.fine_system.service.MultaService;

@Controller
public class MultaController {

	@Autowired MultaService multaService;
	
	@Autowired InfracaoService infracaoService;
	@Autowired CarroService carroService;
	
	@GetMapping("/multas")
	public ModelAndView ListarMultas() {
		ModelAndView mv = new ModelAndView("ListaMultas");
		
		mv.addObject("multas", multaService.buscarTodos());
		mv.addObject("infracoes", infracaoService.buscarTodos());
		mv.addObject("carros", carroService.buscarTodos());
		mv.addObject("multa", new Multa()); // Adiciona um objeto Multa vazio para o formulário de cadastro
		
		return mv;
		
	}
	
	@PostMapping("/multas")
	public String SalvarMulta(@ModelAttribute Multa multa) {
		multaService.salvar(multa);
		return "redirect:/multas";
	}
	
	@GetMapping("/multas/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("EditaMultas");
		modelAndView.addObject(multaService.procurar(id));
		return modelAndView;
	}

	@GetMapping("/multas/deletar/{id}")
	public String deletar(@PathVariable("id") Long id) {
		multaService.deletar(id);
		return "redirect:/multas";
	}
	
}
