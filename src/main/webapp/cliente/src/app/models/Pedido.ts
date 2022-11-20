export class Pedido {
	/*private*/ id?: String;
    /*private*/ nombrePlato :String;
    /*private*/ precioPlato: Number;
    /*private*/ cantidadPlato: Number;
    /*private*/ precioTotal: number;
    /*private*/ pedidoRealizado: boolean;
    /*private*/ idCliente: String;
	/*private*/ idEntrega: String;
	/*private*/ nombreRestaurante: String
    
    
    constructor(NombrePlato: String, precioPlato: number, cantidadPlato: number, idCliente:String,nombreRestaurante: String){
        this.nombrePlato = NombrePlato;
        this.precioPlato = precioPlato;
        this.cantidadPlato = cantidadPlato;
        this.precioTotal = precioPlato * cantidadPlato;
        this.pedidoRealizado = false;
		this.idCliente= idCliente;
		this.idEntrega = "";
		this.nombreRestaurante = nombreRestaurante;
		
        
    }
	get_id(): String | undefined {
		return this.id;
	}

	getNombrePlato(): String {
		return this.nombrePlato;
	}

	getPrecioPlato(): Number {
		return this.precioPlato;
	}
	getCantidadPlato(): Number {
		return this.cantidadPlato;
	}
	getPrecioTotal(): number {
		return this.precioTotal;
	}
	getPedidoRealizado(): boolean {
		return this.pedidoRealizado;
	}
	getidCliente(): String {
		return this.idCliente;
	}
	getidEntrega(): String {
		return this.idEntrega;
	}

    pedidorealizado() : void{
        this.pedidoRealizado = true;
    }

}