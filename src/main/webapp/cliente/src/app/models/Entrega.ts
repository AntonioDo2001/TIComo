import { StringExpressionOperatorReturningObject } from "mongoose";

export class Entrega {
	/*private*/ id?: String;
    /*private*/ idRider: String;
    /*private*/ idCliente: String;
    /*private*/ nombreCliente :String;
    /*private*/ apellidosCliente: String;
    /*private*/ direccion: String;
    /*private*/ telefonoCliente: String;
    /*private*/ fechayhora?: String;
    /*private*/ pedidosRealizados: String;
    /*private*/ estado: String;
    /*private*/ entregado: boolean;
    /*private*/ precioTotal: number;
    /*private*/ nombreRestaurante: String;

    
    
    
    constructor(idCliente: String, nombreCliente: String, apellidosCliente:String, direccion:String, telefonoCliente:String, pedidosRealizados:String, precioTotal:number,nombreRestaurante: String){
        this.idRider = ""
        this.idCliente = idCliente
        this.nombreCliente = nombreCliente
        this.apellidosCliente = apellidosCliente
        this.direccion = direccion
        this.telefonoCliente = telefonoCliente
        this.entregado = false
        let date: Date = new Date();
        this.fechayhora = date.toDateString() +" " + date.getHours() + ":" + date.getMinutes();
        this.pedidosRealizados = pedidosRealizados;
        this.estado = "listo";
        this.precioTotal = precioTotal;
        this.nombreRestaurante = nombreRestaurante;

        
    }
	get_id(): String | undefined {
		return this.id;
	}
    
    public setid(id : String | undefined) {
        this.id = id;
    }
    public setfechayhora(fechayhora : String | undefined) {
        this.fechayhora = fechayhora;
    }
    

	getidRider(): String {
		return this.idRider;
	}

	getidCliente(): String {
		return this.idCliente;
	}
	getNombreCliente(): String {
		return this.nombreCliente;
	}
	getApellidosCliente(): String {
		return this.apellidosCliente;
	}
	getDireccion(): String {
		return this.direccion;
	}
	gettelefonoCliente(): String {
		return this.telefonoCliente;
	}
    getEntregado(): boolean {
        return this.entregado;
    }

    entregaRealizada() : void{
        this.entregado = true;
    }
    

}