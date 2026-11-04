package br.edu.ifms.fine_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.fine_system.model.Multa;
import br.edu.ifms.fine_system.service.MultaService;

@Controller
public class MultaController {

	@Autowired MultaService multaService;
	
	@GetMapping("/multas")
	public ModelAndView ListarMultas() {
		ModelAndView mv = new ModelAndView("ListaMultas");
		
		mv.addObject("MultaDB", multaService.buscarTodos());
		mv.addObject("multa", new Multa()); // Adiciona um objeto Multa vazio para o formulário de cadastro
		
		return mv;
		
	}
}
