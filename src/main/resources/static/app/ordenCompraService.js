/*
* Singleton de ordenesCompra
*/
var ordenesCompra=[];

class OrdenCompraService{
	
	//obtener la lista de ordenesCompra de producto
	static get(){
		return new Promise((resolve)=>{
			 
	        if(ordenesCompra.length==0)
		        $.ajax({
		          url:'/ordenes-compra',
		          method:'get',
		          success:(resp)=>{
		            console.log(resp);
		            if(resp.error==0){
		              ordenesCompra=resp.data;
		              resolve(ordenesCompra);
		            }
		          }
		        });
		    else
		    	resolve(ordenesCompra);
			 
		});
	}



}