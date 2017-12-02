/*
* Singleton de notaVentas
*/
var notaVentas=[];

class NotaVentaService{
	
	//obtener la lista de notaVentas de producto
	static get(){
		return new Promise((resolve)=>{
			 
	        if(notaVentas.length==0)
		        $.ajax({
		          url:'/notas-venta',
		          method:'get',
		          success:(resp)=>{
		            console.log(resp);
		            if(resp.error==0){
		              notaVentas=resp.data;
		              resolve(notaVentas);
		            }
		          }
		        });
		    else
		    	resolve(notaVentas);
			 
		});
	}

	static getLastRowIndex(){
		return new Promise((resolve)=>{	        
	        $.ajax({
	          url:'/notas-venta/ultimo-indice',
	          method:'get',
	          success:(resp)=>{
	            if(resp.error==0){
	              resolve(resp.data[0]);
	            }
	          }
	        });
		});	
	}
}