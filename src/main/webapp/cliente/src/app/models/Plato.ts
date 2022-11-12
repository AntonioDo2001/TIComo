export class Plato {
	/*private*/ id?: String;
    /*private*/ nombre :String;
    /*private*/ foto: String;
    /*private*/ descripcion: String;
    /*private*/ precio: Number;
    /*private*/ aptoVeganos: boolean;
    /*private*/ nombreRestaurante: String;
    
    
    constructor(Nombre: String, Foto: String, Descripcion: String,Precio: Number,AptoVeganos: boolean, nombreRestaurante:String){
        this.nombre = Nombre;
        this.foto = Foto;
        this.descripcion = Descripcion;
        this.precio = Precio;
        this.aptoVeganos = AptoVeganos;
		this.nombreRestaurante= nombreRestaurante;
        
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
	getnombreRestaurante(): String {
		return this.nombreRestaurante;
	}
}