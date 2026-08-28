package br.edu.ifms.fine_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarroController {

	@GetMapping("/carros")
	public String listar() {
		return "ListaCarro";
	}
}
