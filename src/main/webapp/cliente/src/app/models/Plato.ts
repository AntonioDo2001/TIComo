export class Plato {
	/*private*/ id?: String;
    /*private*/ nombre :String;
    /*private*/ foto: String;
    /*private*/ descripcion: String;
    /*private*/ precio: Number;
    /*private*/ aptoVeganos: boolean;
    /*private*/ idRestaurante: String;
    
    
    constructor(Nombre: String, Foto: String, Descripcion: String,Precio: Number,AptoVeganos: boolean, idRestaurante:String){
        this.nombre = Nombre;
        this.foto = Foto;
        this.descripcion = Descripcion;
        this.precio = Precio;
        this.aptoVeganos = AptoVeganos;
		this.idRestaurante= idRestaurante;
        
    }
	get_id(): String | undefined {
		return this.id;
	}

	getNombre(): String {
		return this.nombre;
	}

	getFoto(): String {
		return this.foto;
	}
	getDescripcion(): String {
		return this.descripcion;
	}
	getPrecio(): Number {
		return this.precio;
	}
	getAptoVeganos(): boolean {
		return this.aptoVeganos;
	}
	getidRestaurante(): String {
		return this.idRestaurante;
	}
}