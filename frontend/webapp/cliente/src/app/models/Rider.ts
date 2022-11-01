import { Usuario } from "./Usuario";

export class Rider extends Usuario{
    /*private*/ nif: String;
    /*private*/ tipoVehiculo: String;
    /*private*/ matricula: String;
    /*private*/ carnet: String;

    
    
    constructor(Nombre: String, Apellidos: String, NIF: String,TipoVehiculo: String,Matricula: String,Carnet: String, Email: String, Password: String){
		super(Nombre,Apellidos,Email,Password);
        this.nif = NIF;
        this.tipoVehiculo = TipoVehiculo;
        this.matricula = Matricula;
        this.carnet = Carnet;
        
    }
	getNIF(): String {
		return this.nif;
	}
	getTipoVehiculo(): String {
		return this.tipoVehiculo;
	}
	getMatricula(): String {
		return this.matricula;
	}
	getCarnet(): String {
		return this.carnet;
	}


}