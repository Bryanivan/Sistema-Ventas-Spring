package com.carlos.sistemat3.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//solo me devuelve html (vista)
@Controller
@RequestMapping("/web")
public class WebsiteController {
	private final String HOME_VIEW="dashboard",
						 LOGIN_VIEW="login",
						 REPORTE_PRODUCTOS_VIEW="reporte_productos",
						 REGISTRO_CLIENTES_VIEW="registro_clientes",
						 REGISTRO_PROVEEDORES_VIEW="registro_proveedores",
						 PERFIL_USUARIO_VIEW="user_profile"
						 ;
	

	@GetMapping("/dashboard")
	public String home() {
		return HOME_VIEW;
	}
	
	
	@GetMapping("/login")
	public String login() {
		return LOGIN_VIEW;
	}
	
	@GetMapping("/reporte_productos")
	public String reporteProductos() {
		return REPORTE_PRODUCTOS_VIEW;
	}
	
	@GetMapping("/registro_clientes")
	public String registroClientes() {
		return REGISTRO_CLIENTES_VIEW;
	}


	@GetMapping("/registro_proveedores")
	public String registroProveedores() {
		return REGISTRO_PROVEEDORES_VIEW;
	}


	@GetMapping("/user_profile")
	public String perfilUsuario() {
		return PERFIL_USUARIO_VIEW;
	}
	
}
