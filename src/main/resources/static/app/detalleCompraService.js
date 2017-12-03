/*
* Singleton de DetalleCompra
*/
var detalleCompras=[];
class DetalleCompraService{

	//obtener la lista de detalleCompras de detalleCompra
	static get(idCompra){
		return new Promise((resolve)=>{

		  	
		        $.ajax({
		          url:`/ordenes-compra/${idCompra}/detalle`,
		          method:'get',
		          success:(resp)=>{
		            console.log(resp);
		            if(resp.error==0){
		              detalleCompras=resp.data;
		              resolve(detalleCompras);
		            }
		          }
		        });
		    

		});
	}



	static save(detalleCompra,idCompra){
		return new Promise((resolve)=>{
		  	
		        $.ajax({
		          url:`/ordenes-compra/${idCompra}/detalle`,
		          method:'post',
		          data:JSON.stringify(detalleCompra),
		          headers: {
		            "content-type": "application/json"
		          },
		          success:(resp)=>{		            
	            	  resolve(resp);
		          },
		          error:(err)=>{
					 resolve({error:1,data:[],message:'error del servidor'});
		          }
		        });
		    

		});
	}
}