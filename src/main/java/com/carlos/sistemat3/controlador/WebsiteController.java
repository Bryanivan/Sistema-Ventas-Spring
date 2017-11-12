package com.carlos.sistemat3.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//solo me devuelve html (vista)
@Controller
@RequestMapping("/web")
public class WebsiteController {
	
	@GetMapping("/dashboard")
	public String home() {
		return "dashboard";
	}
	

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/reporte")
	public String table() {
		return "table";
	}
}
