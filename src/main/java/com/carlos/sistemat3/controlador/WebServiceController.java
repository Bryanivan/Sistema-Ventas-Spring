package com.carlos.sistemat3.controlador;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.carlos.sistemat3.modelo.Response;
import com.carlos.sistemat3.modelo.Identificador;
import com.carlos.sistemat3.entidad.User;
import com.carlos.sistemat3.entidad.Producto;
import com.carlos.sistemat3.entidad.Cliente;
import com.carlos.sistemat3.entidad.Proveedor;
import com.carlos.sistemat3.entidad.EstadoTabla;
import com.carlos.sistemat3.entidad.PlazoPago;
import com.carlos.sistemat3.servicio.UsuarioServicio;
import com.carlos.sistemat3.servicio.ClienteServicio;
import com.carlos.sistemat3.servicio.ProductoServicio;
import com.carlos.sistemat3.servicio.ProveedorServicio;
import com.carlos.sistemat3.servicio.EstadoTablaServicio; 
import com.carlos.sistemat3.servicio.PlazoPagoServicio;

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
	
	
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServicio clienteServicio;

	@Autowired
	@Qualifier("proveedorServicio")
	private ProveedorServicio proveedorServicio;
	
	
	@Autowired
	@Qualifier("estadoTablaServicio")
	private EstadoTablaServicio estadoTablaServicio;
		
	@Autowired
	@Qualifier("plazoPagoServicio")
	private PlazoPagoServicio plazoPagoServicio;
	
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
	 * Ingresar un nuevo usuario
	 * @return status si ha sido exitoso o no
	 * */
	@PostMapping("/usuarios")
	public Response addUsuario(@RequestParam(value="username",defaultValue="-1")String username,
							   @RequestParam(value="password",defaultValue="-1")String password) {
		if(username!="-1" && password!="-1") {
			usuarioServicio.add(new User(username,password));			
			return new Response<>(Response.STATUS_OK,"El usuario ha sido registrado con éxito");
		}
		
		return new Response<>(Response.STATUS_ERROR,"No se han ingresado los parámetros correctamente");
	}
	
	/**
	 * Actualizar datos del usuario
	 * @param id del usuario a actualizar
	 * @param username del usuario
	 * @param password del usuario
	 * @return status si ha sido exitoso o no 
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
	 * @return status si ha sido exitoso o no
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
	 * Login
	 * @param username del usuario
	 * @param password del usuario 
	 * @return token de la sección actual
	 * */
	@GetMapping("/auth")
	public Response login(@RequestParam(value="username",defaultValue="-1")String username,
		      			  @RequestParam(value="password",defaultValue="-1")String password) {
		
		int exists=usuarioServicio.exists(username,password);
		
		if(exists!=0)//existe
			return new Response<>(Response.STATUS_OK,"http://localhost:8080/web/dashboard");
		
		return new Response<>(Response.STATUS_ERROR,"El usuario no existe");
	}
	
	/*Api Clientes*/
	/*
	 * Obtener todos los clientes
	 * @return listado de clientes 
	 * */
	@GetMapping("/clientes")
	public Response getClientes(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
			 					@RequestParam(value="filtro",defaultValue="-1")Integer filtro){
		
		//buscando filtrando
		if(valorBusqueda!="-1" && filtro!=-1)
			switch(filtro){
				//buscar por nombres
				case 2:
					return new Response<Cliente>(Response.STATUS_OK,clienteServicio.findByNombreCompleto(valorBusqueda));					
				default: //por dni o ruc
					return new Response<Cliente>(Response.STATUS_OK,clienteServicio.findByRucODni(valorBusqueda));

			}
		
		//en otro caso, se obtiene la lists completa
		return new Response<Cliente>(Response.STATUS_OK,clienteServicio.all());
	}

	
	
	/*
	 * Obtener al cliente por dniORuc
	 * @param rucdni del clente
	 * @return listado de clientes
	 */
	@GetMapping("/clientes/{rucdni}")
	public Response getClientesBy(@PathVariable("rucdni")String rucdni){				
		return new Response<Cliente>(Response.STATUS_OK,clienteServicio.findByRucODni(rucdni));
	}
	
	/**
	 * Registrar un nuevo cliente
	 * @param rucdni Ruc o Dni del cliente
	 * @param nombre nombre del cliente
	 * @param direccionFiscal dirección fiscal del cliente
	 * @param direccionEntrega dirección de entraga del cliente
	 * @param telefono del cliente
	 * @param email del lciente
	 * @return status si ha sido exitoso o no
	 * */
	@PostMapping("/clientes")
	public Response addcliente(@RequestBody Cliente cliente) {
		Cliente clienteResultante=clienteServicio.add(cliente);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(clienteResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El cliente se ha agregado con éxito",identificadores);
	}

	

	/**
	 * Actualizar cliente existente
	 * @param rucdni Ruc o Dni del cliente
	 * @param nombre nombre del cliente
	 * @param direccionFiscal dirección fiscal del cliente
	 * @param direccionEntrega dirección de entraga del cliente
	 * @param telefono del cliente
	 * @param email del lciente
	 * @return status si ha sido exitoso o no
	 * */
	@PutMapping("/clientes")
	public Response updateProducto(@RequestBody Cliente cliente) {
		Integer clienteId= cliente.getId();
		//si el usario a asignado el id
		if(clienteId!=null) {
			clienteServicio.update(cliente);			
			return new Response<Cliente>(Response.STATUS_OK,"El cliente se ha modificado con éxito");
		}
		
		return new Response<>(Response.STATUS_ERROR,"El id es necesario para modificar el cliente"); 
	}
	
	/*Api de productos*/
	
	/**
	 * Obtener todos los productos
	 * @return listado de productos
	 * */
	@GetMapping("/productos")
	public Response getProductos(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								 @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {
		
		
			//buscando filtrando
			if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findByNombre(valorBusqueda));					
					default: //por id
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findById(Integer.parseInt(valorBusqueda)));

				}
			
		//en otro caso, se obtiene la lists completa
		return new Response<Producto>(Response.STATUS_OK,productoServicio.all());
	}
	
	
	
	/**
	 * registrar producto
	 * @param descripcion del producto
	 * @param precioCompra del producto
	 * @param precioVenta del producto
	 * @param precioPack7 
	 * @param precioPack15
	 * @param stock del producto
	 * @return producto
	 * */
	@PostMapping("/productos")
	public Response addProducto(@RequestBody Producto producto) {
		Producto productoResultante=productoServicio.add(producto);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(productoResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El producto se ha agregado con éxito",identificadores);
	}


	/**
	 * modificar producto por id
	 * @param id del producto
	 * @param precioCompra del producto
	 * @param precioVenta del producto
	 * @param precioPack7 
	 * @param precioPack15
	 * @param stock del producto
	 * @return producto
	 * */
	@PutMapping("/productos")
	public Response updateProducto(@RequestBody Producto producto) {
		Integer productoId= producto.getId();
		//si el usario a asignado el id
		if(productoId!=null) {
			productoServicio.update(producto);			
			return new Response<Producto>(Response.STATUS_OK,"El producto se ha modificado con éxito");
		}
		
		return new Response<>(Response.STATUS_ERROR,"El id es necesario para modificar el producto"); 
	}


	
	/*Api Proveedores*/
	/*
	 * Obtener todos los clientes
	 * @return listado de clientes 
	 * */
	@GetMapping("/proveedores")
	public Response getProveedores(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								 @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {			
			//buscando filtrando
			if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Proveedor>(Response.STATUS_OK,proveedorServicio.findByRazonSocial(valorBusqueda));					
					default: //por id
						return new Response<Proveedor>(Response.STATUS_OK,proveedorServicio.findByRuc(valorBusqueda));

				}
			
		//en otro caso, se obtiene la lists completa
		return new Response<Proveedor>(Response.STATUS_OK,proveedorServicio.all());
	}
	
	
	
	/**
	 * registrar proveedor
	 * @param razonsocial del proveedor
	 * @param ruc del proveedor
	 * @param email del proveedor 
	 * @param telefono del proveedor	 
	 * @return status si el registro ha sido exitoso o no
	 * */
	@PostMapping("/proveedores")
	public Response addProveedor(@RequestBody Proveedor proveedor) {
		Proveedor proveedorResultante=proveedorServicio.add(proveedor);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(proveedorResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El proveedor se ha agregado con éxito",identificadores);
	}

	

	/**
	 * actualizar proveedor
	 * @param razonsocial del proveedor
	 * @param ruc del proveedor
	 * @param email del proveedor 
	 * @param telefono del proveedor	 
	 * @return status si el registro ha sido exitoso o no
	 * */
	@PutMapping("/proveedores")
	public Response updateProveedor(@RequestBody Proveedor proveedor) {
		Integer proveedorId= proveedor.getId();
		//si el usario a asignado el id
		if(proveedorId!=null) {
			proveedorServicio.update(proveedor);			
			return new Response<Proveedor>(Response.STATUS_OK,"El proveedor se ha modificado con éxito");
		}
		
		return new Response<>(Response.STATUS_ERROR,"El id es necesario para modificar el proveedor"); 
	}

	
	/*Api Estados tablas*/
	
	/*
	 * Obtener todos los clientes
	 * @return listado de clientes 
	 * */
	@GetMapping("/estados/{tabla}")
	public Response getEstados(@PathVariable("tabla")String tabla){
		return new Response<EstadoTabla>(Response.STATUS_OK,estadoTablaServicio.findByNombreTabla(tabla));
	}
	
	
	/*Api de facturas*/
	
	/*Api de estados de pago*/
	@GetMapping("/plazos-pago")
	public Response getPazosPago() {
		return new Response<PlazoPago>(Response.STATUS_OK,plazoPagoServicio.all());
	}
	
	/*obtener hora del sistema- pendiente*/
	
}
