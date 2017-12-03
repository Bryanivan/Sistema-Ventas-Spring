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
						 SIGN_UP_VIEW="sign_up",
						 REPORTE_PRODUCTOS_VIEW="reporte_productos",
						 REGISTRO_CLIENTES_VIEW="registro_clientes",
						 REGISTRO_PROVEEDORES_VIEW="registro_proveedores",
						 PERFIL_USUARIO_VIEW="user_profile",
						 REPORTE_VENTAS_VIEW="reporte_ventas",
						 REPORTE_COMPRAS_VIEW="reporte_compras",
						 GENERAR_FACTURA_VIEW="generar_factura",
						 GENERAR_ORDEN_COMPRA_VIEW="generar_orden_compra"
						 ;
	

	@GetMapping("/dashboard")
	public String home() {
		return HOME_VIEW;
	}
	
	
	@GetMapping("/login")
	public String login() {
		return LOGIN_VIEW;
	}

	@GetMapping("/sign_up")
	public String signUp() {
		return SIGN_UP_VIEW;
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

	@GetMapping("/reporte_compras")
	public String reporteCompras() {
		return REPORTE_COMPRAS_VIEW;
	}

	@GetMapping("/reporte_ventas")
	public String reporteVentas() {
		return REPORTE_VENTAS_VIEW;
	}

	@GetMapping("/generar_factura")
	public String generarFactura() {
		return GENERAR_FACTURA_VIEW;
	}

	@GetMapping("/generar_orden_compra")
	public String generarOrdenCompra() {
		return GENERAR_ORDEN_COMPRA_VIEW;
	}
	
	@GetMapping("/user_profile")
	public String perfilUsuario() {
		return PERFIL_USUARIO_VIEW;
	}
	
}
