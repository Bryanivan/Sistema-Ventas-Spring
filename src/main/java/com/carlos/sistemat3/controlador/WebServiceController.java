package com.carlos.sistemat3.controlador;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.carlos.sistemat3.modelo.Factura;
import com.carlos.sistemat3.modelo.Response;
import com.carlos.sistemat3.entidad.User;
import com.carlos.sistemat3.entidad.Producto;
import com.carlos.sistemat3.servicio.UsuarioServicio;
import com.carlos.sistemat3.servicio.ProductoServicio;

@RestController
public class WebServiceController {
	private final Log LOG= LogFactory.getLog(WebServiceController.class); 
	
	//servicios
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServicio productoServicio;
	
	
	/*Api Usuarios*/
	
	/**
	 * Obtener todos los usuarios
	 * @return listado de usuarios
	 * */
	@GetMapping("/usuarios")
	public Response getUsuarios() {		
		return new Response<User>(Response.STATUS_OK, usuarioServicio.all());
	}
	
	
	/**
	 * Obtener todos los usuarios
	 * @return listado de usuarios
	 * */
	@PostMapping("/usuarios")
	public Response addUsuario(@RequestParam(value="username",defaultValue="-1")String username,
							   @RequestParam(value="password",defaultValue="-1")String password) {
		if(username!="-1" && password!="-1") {
			usuarioServicio.add(new User(username,password));			
			return new Response<>(Response.STATUS_OK);
		}
		
		return new Response<>(Response.STATUS_ERROR,"No se han ingresado los parámetros correctamente");
	}
	
	/**
	 * Actualizar todos los usuarios
	 * @return response
	 * */
	@PutMapping("/usuarios")
	public Response updateUsuario(@RequestParam(value="id",defaultValue="-1")int id,
								  @RequestParam(value="username",defaultValue="-1")String username,
							      @RequestParam(value="password",defaultValue="-1")String password) {
		if(username!="-1" && password!="-1" && id!=-1) {
			usuarioServicio.update(new User(id,username,password));			
			return new Response<>(Response.STATUS_OK);
		}
		
		return new Response<>(Response.STATUS_ERROR,"No se han ingresado los parámetros correctamente");
	}
	
	
	/**
	 * Eliminar un usuario
	 * @param id identificador del usuario
	 * @return una respuesta con el status
	 * */
	@DeleteMapping("/usuarios")
	public Response removeUsuario(@RequestParam(value="id")int id) {		
		try {
			
			usuarioServicio.remove(id);
			return new Response<>(Response.STATUS_OK);
			
		}catch(Exception err) {
			LOG.error(err);
		}
		return new Response<>(Response.STATUS_ERROR,"No has ingresado correctamente el parámetro id");
	}
	
	/**
	 * autorizar login
	 * @return token
	 * */
	@GetMapping("/auth")
	public Response login(@RequestParam(value="username",defaultValue="-1")String username,
		      			  @RequestParam(value="password",defaultValue="-1")String password) {
		int exists=usuarioServicio.exists(username,password);
		return new Response<>(Response.STATUS_OK,exists+"");
	}
	
	/**
	 * Obtener todos los productos
	 * @return listado de productos
	 * */
	@GetMapping("/productos")
	public List<Producto> getProductos() {		
		return productoServicio.all();
	}
	
	/**
	 * Obtener solo producto
	 * @return objeto producto
	 *
	@GetMapping("/productos")
	public Producto getProducto(@RequestParam(value="id",defaultValue="1")int id) {	
		return productoServicio.get(id);
	} */
	
	@PostMapping("/facturas")
	public Factura getFacturas() {
		return null;//new Factura(1,productos);
	}
	
		
}
