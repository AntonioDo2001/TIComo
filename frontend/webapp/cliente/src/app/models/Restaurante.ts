export class Restaurante {
	/*private*/ id?: String;
    /*private*/ nombre :String;
    /*private*/ razonSocial: String;
    /*private*/ cif: String;
    /*private*/ direccionCompleta: String;
    /*private*/ telefono: String;
    /*private*/ email: String;
    /*private*/ categoria: String;
    
    
    constructor(Nombre: String, RazonSocial: String, CIF: String,DireccionCompleta: String,Telefono: String, Email: String, Categoria: String){
        this.nombre = Nombre;
        this.razonSocial = RazonSocial;
        this.cif = CIF;
        this.direccionCompleta = DireccionCompleta;
        this.telefono = Telefono;
        this.email = Email;
        this.categoria = Categoria;
        
    }
	get_id(): String | undefined {
		return this.id;
	}

	getNombre(): String {
		return this.nombre;
	}

	getRazonSocial(): String {
		return this.razonSocial;
	}
	getCIF(): String {
		return this.cif;
	}
	getDireccionCompleta(): String {
		return this.direccionCompleta;
	}
	getTelefono(): String {
		return this.telefono;
	}
	getEmail(): String {
		return this.email;
	}
	getCategoria(): String {
		return this.categoria;
	}

}