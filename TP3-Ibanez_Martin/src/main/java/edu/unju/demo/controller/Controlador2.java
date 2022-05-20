package edu.unju.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controlador2 {
	@RequestMapping("/pagina3")
	
	public String pagina3() {
		return "<h1>Pagina 3</h1><br>"
				+ "<h2><a href=\"index.html\">INICIO</a></h2>";
	}
}
