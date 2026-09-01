package br.edu.ifms.fine_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.fine_system.model.Carro;

@Controller
public class CarroController {

	@GetMapping("/carros")
	public ModelAndView listarCarros() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		mv.addObject("carros", buscarCarros());
		return mv;
	}
	
	public List<Carro> buscarCarros() {
		// Aqui você pode implementar a lógica para buscar os carros do banco de dados
		// Por enquanto, vamos retornar uma lista de exemplo
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(1L, "Modelo A", "ABC-1234", "Vermelho"));
		return carros;
	}
}
