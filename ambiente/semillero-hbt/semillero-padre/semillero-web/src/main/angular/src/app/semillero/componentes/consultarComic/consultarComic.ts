import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ComicDTO } from '../../dto/comic.dto';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * componente donde se va a poder ver la informacion del comic seleccionado
 */
@Component({
    selector: 'consultarComic',
    templateUrl: './consultarComic.html'
})

/**
 * declaracion de la exportacion de la clase
 */
export class ConsultarComicComponent implements OnInit {

    /**
      * Atributo que contiene los controles del formulario
      */
    public consultarComicForm: FormGroup;

    /**
     * atributo que va a contener los datos del comic seleccionado
     */
    public data: any;

   

    /**
     * constructor del componente
     */
    constructor(private fb: FormBuilder,
        private router: Router, private activatedRoute: ActivatedRoute) {
        this.consultarComicForm = this.fb.group({
            nombre: [null],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }


    /**
     * evento angular que se invoca al llamar al componente
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        //cargamos en data el comic seleccionado
        this.data = this.activatedRoute.snapshot.params;
        this.mostarDatosComic();
    }

    /**
     * metodo que muestra los datos en los respectivos campos
     */
    public mostarDatosComic(): void {
        //rellenamos los campos con los datos del comic seleccionado

        this.consultarComicForm.controls.nombre.setValue(this.data.nombre);
        this.consultarComicForm.controls.editorial.setValue(this.data.editorial);
        this.consultarComicForm.controls.tematica.setValue(this.data.tematica);
        this.consultarComicForm.controls.coleccion.setValue(this.data.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(this.data.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(this.data.precio);
        this.consultarComicForm.controls.autores.setValue(this.data.autores);
        this.consultarComicForm.controls.color.setValue(this.data.color);

        //Lo volvemos disable para que no se pueda editar
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
    }

    /**
     * metodo que nos redirige a gestionar comic
     */
    gestionarComic(): void {
        this.router.navigate(['gestionar-comic']);
    }
}
