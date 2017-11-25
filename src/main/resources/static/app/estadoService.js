/*
* Singleton de Estado
*/
var estados=[];

class EstadoService{
	
	//obtener la lista de estados de producto
	static get(){
		return new Promise((resolve)=>{
			 
	        if(estados.length==0)
		        $.ajax({
		          url:'/estados/producto',
		          method:'get',
		          success:(resp)=>{
		            console.log(resp);
		            if(resp.error==0){
		              estados=resp.data;
		              resolve(estados);
		            }
		          }
		        });
		    else
		    	resolve(estados);
			 
		});
	}

}