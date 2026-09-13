package br.edu.ifms.fine_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.fine_system.model.Carro;
import br.edu.ifms.fine_system.repository.Carros;

@Controller
public class CarroController {
	
	@Autowired
	private Carros carros;

	@GetMapping("/carros")
	public ModelAndView listarCarros() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		mv.addObject("carros", buscarCarros());
		mv.addObject("carrosDB", carros.findAll());
		return mv;
	}
	
	public List<Carro> buscarCarros() {
		// Aqui você pode implementar a lógica para buscar os carros do banco de dados
		// Por enquanto, vamos retornar uma lista de exemplo
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro(1L, "Modelo A", "ABC-1234", "Vermelho"));
		carros.add(new Carro(2L, "Modelo B", "DEF-5678", "Azul"));
		carros.add(new Carro(3L, "Modelo C", "HTA-2728", "Branco"));
		return carros;
	}
}
