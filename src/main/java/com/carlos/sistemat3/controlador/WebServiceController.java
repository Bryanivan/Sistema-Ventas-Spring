package com.carlos.sistemat3.controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.carlos.sistemat3.configuracion.PdfGenaratorUtil;
import com.carlos.sistemat3.entidad.Cliente;
import com.carlos.sistemat3.entidad.Proveedor;
import com.carlos.sistemat3.entidad.EstadoTabla;
import com.carlos.sistemat3.entidad.PlazoPago;
import com.carlos.sistemat3.entidad.Empleado;
import com.carlos.sistemat3.entidad.Factura;
import com.carlos.sistemat3.entidad.NotaVenta;
import com.carlos.sistemat3.entidad.DetalleVenta;
import com.carlos.sistemat3.entidad.OrdenCompra;
import com.carlos.sistemat3.entidad.DetalleCompra;
import com.carlos.sistemat3.entidad.Rol;
import com.carlos.sistemat3.servicio.UsuarioServicio;
import com.carlos.sistemat3.servicio.RolServicio;
import com.carlos.sistemat3.servicio.ClienteServicio;
import com.carlos.sistemat3.servicio.ProductoServicio;
import com.carlos.sistemat3.servicio.ProveedorServicio;
import com.carlos.sistemat3.servicio.EstadoTablaServicio; 
import com.carlos.sistemat3.servicio.PlazoPagoServicio;
import com.carlos.sistemat3.servicio.EmpleadoServicio;
import com.carlos.sistemat3.servicio.FacturaServicio;
import com.carlos.sistemat3.servicio.NotaVentaServicio;
import com.carlos.sistemat3.servicio.DetalleVentaServicio;
import com.carlos.sistemat3.servicio.OrdenCompraServicio;
import com.carlos.sistemat3.servicio.DetalleCompraServicio;

@RestController
public class WebServiceController {
	private final Log LOG= LogFactory.getLog(WebServiceController.class); 
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
	//servicios
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	@Qualifier("rolServicio")
	private RolServicio rolServicio;
	
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
	
	
	@Autowired
	@Qualifier("empleadoServicio")
	private EmpleadoServicio empleadoServicio;
	
	
	@Autowired
	@Qualifier("facturaServicio")
	private FacturaServicio facturaServicio;
		
	@Autowired
	@Qualifier("notaVentaServicio")
	private NotaVentaServicio notaVentaServicio;
	
	@Autowired
	@Qualifier("detalleVentaServicio")
	private DetalleVentaServicio detalleVentaServicio;
	
	@Autowired
	@Qualifier("ordenCompraServicio")
	private OrdenCompraServicio ordenCompraServicio;
	
	@Autowired
	@Qualifier("detalleCompraServicio")
	private DetalleCompraServicio detalleCompraServicio;
	
	
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
	@GetMapping("/usuarios/{token}")
	public Response getUsuarioByToken(@PathVariable("token")String token) {			
		return new Response<User>(Response.STATUS_OK, usuarioServicio.findByAuthToken(token));
	}
	
	/**
	 * Ingresar un nuevo usuario
	 * @return status si ha sido exitoso o no
	 * */
	@PostMapping("/usuarios")
	public Response addUsuario(@RequestParam(value="email",defaultValue="-1")String email,
							   @RequestParam(value="displayName",defaultValue="-1")String displayName,
							   @RequestParam(value="photoURL",defaultValue="-1")String photoURL,
							   @RequestParam(value="rolId",defaultValue="-1")int rolId,
							   @RequestParam(value="token",defaultValue="-1")String token,
							   @RequestParam(value="refreshToken",defaultValue="-1")String refreshToken) {
		if(email!="-1" && token!="-1") {
			//reciviendo el usuario recién insertado
			User usuarioAgregado=usuarioServicio.add(new User(email,rolId,token,refreshToken));
			empleadoServicio.add(new Empleado(displayName,photoURL,rolId,usuarioAgregado.getId()));
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
	
	/*Api Roles*/
	/**
	 * Obtener todos los roles
	 * @return listado de roles
	 * */
	@GetMapping("/roles")
	public Response getRoles() {		
		return new Response<Rol>(Response.STATUS_OK, rolServicio.all());
	}
	
	/*Api Empleados*/
	/**
	 * Obtener todos los empleados
	 * @return listado de empleados
	 * */
	@GetMapping("/empleados")
	public Response getEmpleados(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								 @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {
		
		
			//buscando filtrando
			/*if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findByNombre(valorBusqueda));					
					default: //por id
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findById(Integer.parseInt(valorBusqueda)));

				}*/
			
		//en otro caso, se obtiene la lists completa
		return new Response<Empleado>(Response.STATUS_OK,empleadoServicio.all());
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
	/**
	 * Obtener todas las facturas
	 * @return listado de facturas
	 * */
	@GetMapping("/facturas")
	public Response getFacturas(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								 @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {
		
		
			//buscando filtrando
			/*if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findByNombre(valorBusqueda));					
					default: //por id
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findById(Integer.parseInt(valorBusqueda)));

				}*/
			
		//en otro caso, se obtiene la lists completa
		return new Response<Factura>(Response.STATUS_OK,facturaServicio.all());
	}
	
	
	/*
	 * @return obtener el último índice generado
	 * */
	@GetMapping("/facturas/ultimo-indice")
	public Response getLastFacturaCode() {
		List<Integer> lastRowCodigo=new ArrayList<>();
		lastRowCodigo.add(facturaServicio.getLastRowCodigo());
		return new Response<Integer>(Response.STATUS_OK,lastRowCodigo);
	}
	
	
	/**
	 * registrar factura
	 * @param id de la factura
	 * @param codigo de la factura
	 * @param fechaEmision de la factura
	 * @param fechaVencimiento de la factura
	 * @param subTotal de la factura
	 * @param descuento de la factura
	 * @param igv de la factura
	 * @param total de la factura
	 * @param empleadoId de la factura
	 * @param plazoPagoId de la factura
	 * @param estadosTablasId de la factura
	 * @param clientesId de la factura
	 * @return status si el registro ha sido exitoso o no
	 * */
	@PostMapping("/facturas")
	public Response addFactura(@RequestBody Factura factura) {
		Factura facturaResultante=facturaServicio.add(factura);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(facturaResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"La factura se ha agregado con éxito",identificadores);
	}
	
	
	/**
	 * Obtener todos los detalle de factura de venta
	 * @return listado de detalle de factura de venta
	 * */
	@GetMapping("/facturas/{facturaId}/detalle")
	public Response getFacturaVentaDetalle(@PathVariable("facturaId")int facturaId) {				
		return new Response<DetalleVenta>(Response.STATUS_OK,detalleVentaServicio.findByFacturaId(facturaId));
	}
	
	/**
	 * registrar detalle de factura
	 * @param id de la factura
	 *  
	 * @param cantidad del detalle
	 * @param precio del detalle 
	 * @return status si el registro ha sido exitoso o no
	 * 
	 * */
	//forzar a ser detalle para factura
	@PostMapping("/facturas/{facturaId}/detalle")
	public Response addFacturaDetalle(@PathVariable("facturaId")int facturaId,@RequestBody DetalleVenta detalleVenta) {
		detalleVenta.setFacturaId(facturaId);
		DetalleVenta detalleVentaResultante=detalleVentaServicio.add(detalleVenta);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(detalleVentaResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El detalle venta se ha agregado con en el nota venta éxito",identificadores);
	}
	
	/*Api nota de venta*/
	/**
	 * Obtener todas las notas de venta
	 * @return listado de notas de venta
	 * */
	@GetMapping("/notas-venta")
	public Response getNotasVenta(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								 @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {
		
		
			//buscando filtrando
			/*if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findByNombre(valorBusqueda));					
					default: //por id
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findById(Integer.parseInt(valorBusqueda)));

				}*/
			
		//en otro caso, se obtiene la lists completa
		return new Response<NotaVenta>(Response.STATUS_OK,notaVentaServicio.all());
	}

	/*
	 * @return obtener el último índice generado
	 * */
	@GetMapping("/notas-venta/ultimo-indice")
	public Response getLastNotaVentaIndex() {
		List<Integer> lastRowCodigo=new ArrayList<>();
		lastRowCodigo.add(notaVentaServicio.getLastRowIndex());
		return new Response<Integer>(Response.STATUS_OK,lastRowCodigo);
	}
	
	/**
	 * registrar nota de venta
	 * @param id de la notaVenta
	 * @param codigo de la notaVenta
	 * @param fechaEmision de la notaVenta
	 * @param subTotal de la notaVenta
	 * @param descuento de la notaVenta
	 * @param igv de la notaVenta
	 * @param total de la notaVenta
	 * @param plazoPagoId de la notaVenta
	 * @param clientesId de la notaVenta
	 * @return status si el registro ha sido exitoso o no
	 * */
	@PostMapping("/notas-venta")
	public Response addNotaVenta(@RequestBody NotaVenta notaVenta) {
		NotaVenta notaVentaResultante=notaVentaServicio.add(notaVenta);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(notaVentaResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El proveedor se ha agregado con éxito",identificadores);
	}

	/**
	 * Obtener todos los detalle de nota de venta
	 * @return listado de detalle de nota de venta
	 * */
	@GetMapping("/notas-venta/{notaVentaId}/detalle")
	public Response getNotaVentaDetalle(@PathVariable("notaId")int notaVentaId) {				
		return new Response<DetalleVenta>(Response.STATUS_OK,detalleVentaServicio.findByNotaVentasId(notaVentaId));
	}
	
	/**
	 * registrar detalle de nota de venta
	 * @param id de la notaVenta
	 *  
	 * @param cantidad del detalle
	 * @param precio del detalle 
	 * @return status si el registro ha sido exitoso o no
	 * 
	 * */
	//forzar a ser detalle para nota de venta
	@PostMapping("/notas-venta/{notaVentaId}/detalle")
	public Response addNotaVentaDetalle(@PathVariable("notaId")int notaVentaId,@RequestBody DetalleVenta detalleVenta) {
		detalleVenta.setNotaVentasId(notaVentaId);
		DetalleVenta detalleVentaResultante=detalleVentaServicio.add(detalleVenta);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(detalleVentaResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El detalle venta se ha agregado con en el nota venta éxito",identificadores);
	}	
	
	/*Api de orden de compra*/

	/**
	 * Obtener todas las ordenes de compra
	 * @return listado de ordenes de compra
	 * */
	@GetMapping("/ordenes-compra")
	public Response getOrdenesCompra(@RequestParam(value="valorBusqueda",defaultValue="-1")String valorBusqueda,
								     @RequestParam(value="filtro",defaultValue="-1")Integer filtro) {			
			//buscando filtrando
			/*if(valorBusqueda!="-1" && filtro!=-1)
				switch(filtro){
					//buscar por nombre
					case 2:
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findByNombre(valorBusqueda));					
					default: //por id
						return new Response<Producto>(Response.STATUS_OK,productoServicio.findById(Integer.parseInt(valorBusqueda)));

				}*/
			
		//en otro caso, se obtiene la lists completa
		return new Response<OrdenCompra>(Response.STATUS_OK,ordenCompraServicio.all());
	}

	

	/**
	 * registrar orden de compra
	 * @param id de la ordenCompra
	 * @param proveedorId de la ordenCompra
	 * @param subTotal de la ordenCompra
	 * @param igv de la ordenCompra
	 * @param total de la ordenCompra
	 * @param fecha de la ordenCompra	 
	 * @return status si el registro ha sido exitoso o no
	 * */
	@PostMapping("/ordenes-compra")
	public Response addOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
		OrdenCompra ordenCompraResultante=ordenCompraServicio.add(ordenCompra);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(ordenCompraResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"La orden de compra se ha agregado con éxito",identificadores);
	}
	
	/**
	 * Obtener todos los detalle de ordenCompra de venta
	 * @return listado de detalle de ordenCompra de venta
	 * */
	@GetMapping("/ordenes-compra/{ordenCompraId}/detalle")
	public Response getOrdenCompraDetalle(@PathVariable("ordenCompraId")int ordenCompraId) {				
		return new Response<DetalleCompra>(Response.STATUS_OK,detalleCompraServicio.findByOrdenCompraId(ordenCompraId));
	}
	
	
	/**
	 * registrar detalle de orden de compra
	 * @param id de la ordenCompra
	 *  
	 * @param cantidad del detalle
	 * @param precio del detalle 
	 * @return status si el registro ha sido exitoso o no
	 * 
	 * */
	@PostMapping("/ordenes-compra/{ordenCompraId}/detalle")
	public Response addOrdenCompraDetalle(@PathVariable("ordenCompraId")int ordenCompraId,@RequestBody DetalleCompra detalleCompra) {
		detalleCompra.setOrdenCompraId(ordenCompraId);
		DetalleCompra detalleCompraResultante=detalleCompraServicio.add(detalleCompra);
		List<Identificador> identificadores=new ArrayList<>();
		identificadores.add(new Identificador(detalleCompraResultante.getId()));
		return new Response<Identificador>(Response.STATUS_OK,"El detalle compra se ha agregado con en el nota venta éxito",identificadores);
	}

	
	
	/*Api de detalle de venta*/
	
	/*Api de estados de pago*/
	@GetMapping("/plazos-pago")
	public Response getPazosPago() {
		return new Response<PlazoPago>(Response.STATUS_OK,plazoPagoServicio.all());
	}
	
	/*obtener hora del sistema- pendiente*/
	@GetMapping("/sistema/tiempo-actual")
	public Response getCurrentTimeSystem() {
		List<LocalDateTime> currentTime=new ArrayList<>();
		currentTime.add(LocalDateTime.now());		
		return new Response<LocalDateTime>(Response.STATUS_OK,currentTime);
	}
	
	@GetMapping("/download/pdf")
	void generarPdf() throws Exception{
		Map<String,String> data = new HashMap<>();
	    data.put("name","Carlos");
	    pdfGenaratorUtil.createPdf("pdf_reporte_ventas",data); 
	}
}
