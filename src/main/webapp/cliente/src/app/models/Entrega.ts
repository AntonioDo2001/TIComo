export class Entrega {
	/*private*/ id?: String;
    /*private*/ idRider: String;
    /*private*/ idCliente: String;
    /*private*/ nombreCliente :String;
    /*private*/ apellidosCliente: String;
    /*private*/ direccion: String;
    /*private*/ telefonoCliente: String;
    /*private*/ entregado: boolean;
    
    
    
    constructor(idCliente: String, nombreCliente: String, apellidosCliente:String, direccion:String, telefonoCliente:String){
        this.idRider = ""
        this.idCliente = idCliente
        this.nombreCliente = nombreCliente
        this.apellidosCliente = apellidosCliente
        this.direccion = direccion
        this.telefonoCliente = telefonoCliente
        this.entregado = false

        
    }
	get_id(): String | undefined {
		return this.id;
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