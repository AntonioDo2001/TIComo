export class Pedido {
	/*private*/ id?: String;
    /*private*/ nombrePlato :String;
    /*private*/ precioPlato: Number;
    /*private*/ cantidadPlato: Number;
    /*private*/ precioTotal: Number;
    /*private*/ pedidoRealizado: boolean;
    /*private*/ idCliente: String;
    
    
    constructor(NombrePlato: String, precioPlato: number, cantidadPlato: number, idCliente:String){
        this.nombrePlato = NombrePlato;
        this.precioPlato = precioPlato;
        this.cantidadPlato = cantidadPlato;
        this.precioTotal = precioPlato * cantidadPlato;
        this.pedidoRealizado = false;
		this.idCliente= idCliente;
        
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
	getPrecioTotal(): Number {
		return this.precioTotal;
	}
	getPedidoRealizado(): boolean {
		return this.pedidoRealizado;
	}
	getidCliente(): String {
		return this.idCliente;
	}

    pedidorealizado() : void{
        this.pedidoRealizado = true;
    }

}