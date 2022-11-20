export class Usuario {
	/*private*/ id?: String;
    /*private*/ nombre :String;
    /*private*/ apellidos: String;
    /*private*/ email: String;
    /*private*/ password: String;
	/*private*/ cuentaActiva: boolean;
    
    
    constructor(Nombre: String, Apellidos: String, Email: String, Password: String){
        this.nombre = Nombre;
        this.apellidos = Apellidos;
        this.email = Email;
        this.password = Password;
		this.cuentaActiva = true;
        
    }
	get_id(): String | undefined {
		return this.id;
	}

	getNombre(): String {
		return this.nombre;
	}

	getApellidos(): String {
		return this.apellidos;
	}

	getEmail(): String {
		return this.email;
	}
	getPassword(): String {
		return this.password;
	}

}