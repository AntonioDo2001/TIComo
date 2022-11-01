import { Usuario } from "./Usuario";

export class Cliente extends Usuario{
    /*private*/ nif: String;
    /*private*/ direccionCompleta: String;
    /*private*/ telefono: String;
    
    
    constructor(Nombre: String, Apellidos: String, NIF: String,DireccionCompleta: String,Telefono: String, Email: String, Password: String){
		super(Nombre,Apellidos,Email,Password);
        this.nif = NIF;
        this.direccionCompleta = DireccionCompleta;
        this.telefono = Telefono;
        
    }
	getNIF(): String {
		return this.nif;
	}
	getDireccionCompleta(): String {
		return this.direccionCompleta;
	}
	getTelefono(): String {
		return this.telefono;
	}


}