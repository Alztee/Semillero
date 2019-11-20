import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../services/gestionar.proveedor.service';
import { ProveedorDTO } from '../../dto/proveedor.dto';

/**
 * componente gestionar proveedor
 */
@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor-component.html'
})


export class GestionarProveedorComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarProveedorForm: FormGroup;

    /**
     * atributo proveedor DTO que nos ayudara a gestionar
     */
    public proveedor: ProveedorDTO;

    /**
     * variable donde se van a almacenar los proveedores
     */
    public listaProveedores: Array<ProveedorDTO>;


    /**
     * metodo que se ejecuta al llamarse al componente
     */
    ngOnInit() {
        this.proveedor = new ProveedorDTO();
        this.listaProveedores = new Array<ProveedorDTO>();
        this.consultarProveedores();
    }

    /**
     * constructor de la clase
     */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarProveedorService: GestionarProveedorService) {
        this.gestionarProveedorForm = this.fb.group({
            nombre: [null, Validators.required],
            direccion: [null, Validators.required],
            monto: [null],
            estado: [null],
            cedula: [null]

        });
    }

    /**
     * metodo que permite limpiar los campos de la pantalla
     */
    private limpiarformulario(): void {
        this.gestionarProveedorForm.controls.nombre.setValue(null);
        this.gestionarProveedorForm.controls.direccion.setValue(null);
        this.gestionarProveedorForm.controls.monto.setValue(null);
        this.gestionarProveedorForm.controls.estado.setValue(null);
        this.gestionarProveedorForm.controls.cedula.setValue(null);
    }

    /**
     * metodo que agrega o edita un proveedor
     */
    public agregarActualizarProveedor(): void {
        if (this.gestionarProveedorForm.invalid) {
            return;
        }
        this.proveedor.nombre = this.gestionarProveedorForm.controls.nombre.value;
        this.proveedor.direccion = this.gestionarProveedorForm.controls.direccion.value;
        this.proveedor.montoCredito = this.gestionarProveedorForm.controls.monto.value;
        this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;
        this.proveedor.cedula = this.gestionarProveedorForm.controls.cedula.value;
        this.proveedor.fechaCreacion=null;
        this.proveedor.id="1";
        

        this.gestionarProveedorService.crearProveedor(this.proveedor);
        this.limpiarformulario();
    }

    /**
     * metodo que permite buscar un proveedor de la lista 
     * @param cedula por la que se busca al proveedor
     * @returns proveedor si lo encuenta, null si no existe
     */
    public buscarProveedor(cedula: string): ProveedorDTO {
        this.proveedor = null;
        for (let i = 0; i < this.listaProveedores.length; i++) {
            if (this.listaProveedores[i].cedula === cedula) {
                this.proveedor = this.listaProveedores[i];
            }

        }
        return this.proveedor;
    }

    /**
     * metodo que permite cambiar el estado del proveedor
     * @param proveedor al que se le va a cambir el estado
     */
    public cambiarEstado(proveedor: any):void{
        this.proveedor=null;
        this.proveedor= this.buscarProveedor(proveedor.cedula);
        if(this.proveedor!=null){
            this.gestionarProveedorService.modificarEstado(this.proveedor);
        }
    }

    /**
     * metodo que permite consultar todos los proveedores existentes
     */
    public consultarProveedores(): void {
        this.gestionarProveedorService.consultarProveedores();
    }

}