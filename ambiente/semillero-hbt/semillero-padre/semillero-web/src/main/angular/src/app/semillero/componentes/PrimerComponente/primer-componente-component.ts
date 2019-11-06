import { Component, OnInit } from '@angular/core';
import {LibroDTO} from '../PrimerComponente/LibroDTO';

//../../../../../../../../../semillero-servicios/src/main/java/com/hbt/semillero/dto/LibroDTO
/**
 * @description Componente primer comentario, el cual contiene el nombre, la ciudad y el 
 * repositorio de Sebastian Alzate
 * 
 * @author Sebastian Alzate <jsalzatel@uqvirtual.edu.co>
 */
@Component({
    selector: 'primer-componente',
    templateUrl: './primer-componente-component.html'

})

/**
 * exportando la clase
 */
export class PrimerComponenteComponent implements OnInit {
    /**
     * variable en la que se almacena el nombre
     */
    public nombre: string;
    /**
     * 
     * variable en la que se almacena la ciudad
     */
    public ciudad: string;
    /**
     * Variable en la que se almacena el repositorio
     */
    public repositorio: string;
    /**
     * objeto libro de prueba
     */
    public  libro: LibroDTO;
    /**
     * Aray que va a almacenar algunos datos del objeto libro
     */
    public listaDatosObjeto: Array<any> = new Array<any>();
    /**
     * Variable que va a almacenar los datos del array los va a convertir en JSOn 
     */
    public listToJSON;
    /**
     * variable para dinamizar un input y usar interpolacion
     */
    public nombreCambiar:string;
    /**
     * variable que se vuelve true cuando se elimina el dato 3 de la lista
     */
    public variableB: boolean;

    /**
     * url de la imagen
     */
    public imgUrl:string;

    /**
  * Evento angular que se ejecuta axcxl iniciar el componente
  */
    ngOnInit(): void {
        //ejercicio sesion 1
        this.nombre = "Sebastian Alzate Leon";
        this.ciudad = "Armenia";
        this.repositorio = "https://github.com/Alztee/Semillero.git";

        //inicializamos false
        this.variableB=false;
        //ponemos cualquier nombre
        this.nombreCambiar="sebastian";
        //inicializamos la imagen
        this.imgUrl="http://lorempixel.com/400/200";
        
        //creamos el objeto libro con los siguientes atributos
        this.libro = new LibroDTO();
        this.libro.nombre="las cronicas de Narnia";
        this.libro.id= 1;
        this.libro.editorial="planeta";
        this.libro.aColor=false;
        this.libro.tematica="aventuras";

        //Agregamos algunos datos al array
        this.listaDatosObjeto.push("id del libro: "+this.libro.id);
        this.listaDatosObjeto.push("nombre del libro: "+this.libro.nombre);
        this.listaDatosObjeto.push("Editorial: "+this.libro.editorial);
        this.listaDatosObjeto.push("esta a color?: "+this.libro.aColor);
        this.listaDatosObjeto.push("tematica: "+this.libro.tematica);

        //guardamos el arreglo en una variable que convierte los datos en .JSOn
       this.listToJSON = JSON.stringify(this.listaDatosObjeto);
    }

    /**
     * metodo que retorna un hola
     */
    saludo():void{
        console.log("hola profe");
    }

    /**
     * metodo eliminar la posicion de la lista que se envia desde el html
     */
    metodoEliminar(num:number):void{
        let aEliminar=this.listaDatosObjeto[num];
        //lo eliminamos
        this.listaDatosObjeto.splice[num];
        console.log("se ha eliminado: "+ aEliminar);
        alert("se ha eliminado la variable: "+ aEliminar)
        // variable que va a leer el ngIf para mostrar el mensaje en la web
        this.variableB=true;
    }
}

