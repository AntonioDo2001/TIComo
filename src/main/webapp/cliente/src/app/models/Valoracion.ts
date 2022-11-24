import { StringExpressionOperatorReturningObject } from "mongoose";

export class Valoracion {
	/*private*/ id?: String;
    /*private*/ idEntrega: String|undefined;
    /*private*/ esRiderORestaurante: String;
    /*private*/ valoracion: number;
    /*private*/ comentario: string;
    /*private*/ idRiderOnombreRestaurante: String;
    
    constructor(idEntrega: String|undefined, esRiderORestaurante: String,valoracion:number, comentario:string, idRiderOnombreRestaurante:String){
        this.idEntrega = idEntrega;
        this.esRiderORestaurante = esRiderORestaurante;
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.idRiderOnombreRestaurante = idRiderOnombreRestaurante;
    }
	

}