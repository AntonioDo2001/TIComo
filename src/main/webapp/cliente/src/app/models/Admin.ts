import { Usuario } from "./Usuario";

export class Admin extends Usuario {
    /*private*/ zona: String;

    
    
    constructor(Nombre: String, Apellidos: String, Zona: String, Email: String, Password: String){
		super(Nombre,Apellidos,Email,Password);
        this.zona = Zona;
        
    }

	getZona(): String {
		return this.zona;
	}


}