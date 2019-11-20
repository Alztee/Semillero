
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    public idComic: number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarComicService: GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
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
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     * si ya esta creado lo actualiza, si no lo crea
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        }
        let comicEncontrado = this.buscarComic(this.gestionarComicForm.controls.nombre.value);
        if (comicEncontrado != null) {
            let posicion: any = comicEncontrado;
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            //this.listaComics[posicion - 1] = this.comic;

            this.gestionarComicService.actualizarComic(this.comic)
        } else {
            this.comic = new ComicDTO();
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.cantidad=12;
            this.comic.estado= "ACTIVO";
            this.comic.color = this.gestionarComicForm.controls.color.value;
            
            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if (resultadoDTO.exitoso) {
                    this.consultarComics();
                    this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        }
        this.limpiarFormulario();
    }

    /**
     * metodo que nos direcciona a consultar comic gracias al router
     * @param comic a consultar
     */
    public consultarComic(comic: any): void {
        this.router.navigate(['consultarComic', comic]);
    }

    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }

    /**
    * metodo que permite eliminar un comic
    * @param comicEliminar, comic a eliminar de la lista
    */
    eliminarComic(comicEliminar: any): void {
        this.comic = new ComicDTO;
        for (let i = 0; i < this.listaComics.length; i++) {
            if (this.listaComics[i].id === comicEliminar.id) {
                this.listaComics.splice(i, 1);
                //this.variableEliminar= true;
                alert("comic: " + comicEliminar.nombre + " eliminado")
                this.gestionarComicService.eliminarComic(this.comic)
            }
        }
        // this.variableEliminar= false;
    }

    /**
     * metodo que carga los datos a los campos para ser editados
     */
    public editarComic(indice: number): void {
        this.comic = this.listaComics[indice];
        this.gestionarComicForm.controls.nombre.setValue(this.comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(this.comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(this.comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(this.comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(this.comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(this.comic.precio);
        this.gestionarComicForm.controls.autores.setValue(this.comic.autores);
        this.gestionarComicForm.controls.color.setValue(this.comic.color);
    }

    /**
     * metodo que permite saber si el comic ya esta en la lista de comics
     * @param comic a buscar
     */
    public buscarComic(nombreComic: string): string {
        for (let i = 0; i < this.listaComics.length; i++) {
            if (this.listaComics[i].nombre === nombreComic.toString() || this.listaComics[i].nombre == nombreComic.toString()) {
                return this.listaComics[i].id;
            }
        }
        return null;
    }

    /**
    * @description Metodo encargado de consultar los comics existentes
    * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
    */
    public consultarComics(): void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

}