package br.edu.ifms.fine_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.fine_system.model.Carro;
import br.edu.ifms.fine_system.repository.Carros;
import br.edu.ifms.fine_system.service.CarroService;

@Controller
public class CarroController {
	
	@Autowired
	private CarroService carroService;

	@GetMapping("/carros")
	public ModelAndView listarCarros() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		
		//mv.addObject("carros", buscarCarros()); // Chamada do método buscarCarros() para obter a lista de carros
		//mv.addObject("carrosDB", carros.findAll());
		
		mv.addObject("carrosDB", carroService.buscarTodos());
		mv.addObject("carro", new Carro());
		
		return mv;
	}
	
	@PostMapping("/carros")
	public String salvarCarro(@ModelAttribute Carro carro) {
		carroService.salvar(carro);
		return "redirect:/carros";
	}
	
	/*
	public List<Carro> buscarCarros() {
		// Aqui você pode implementar a lógica para buscar os carros do banco de dados
		// Por enquanto, vamos retornar uma lista de exemplo
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(1L, "Modelo A", "ABC-1234", "Vermelho"));
		carros.add(new Carro(2L, "Modelo B", "DEF-5678", "Azul"));
		carros.add(new Carro(3L, "Modelo C", "HTA-2728", "Branco"));
		return carros;
	}
	*/
	
}
