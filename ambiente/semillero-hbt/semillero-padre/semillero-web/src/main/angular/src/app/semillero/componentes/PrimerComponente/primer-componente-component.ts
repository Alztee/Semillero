import { Component, OnInit } from '@angular/core';

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
export class PrimerComponenteComponent implements OnInit{
    /**
     * variable en la que se almacena el nombre
     */
    nombre=null;
    /**
     * variable en la que se almacena la ciudad
     */
    ciudad=null;
    /**
     * Variable en la que se almacena el repositorio
     */
    repositorio=null;

     /**
   * Evento angular que se ejecuta al iniciar el componente
   */
  ngOnInit(): void {
       this.nombre= "Sebastian Alzate Leon";
       this.ciudad= "Armenia";
       this.repositorio= "https://github.com/Alztee/Semillero.git";
      

}
}

