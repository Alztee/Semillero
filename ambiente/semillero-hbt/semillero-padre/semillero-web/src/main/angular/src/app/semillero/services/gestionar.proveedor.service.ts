import { Injectable, Injector } from '@angular/core';
import { HttpClient, HttpHeaders } from  '@angular/common/http';
import { AbstractService } from './template.service';
import { Observable } from 'rxjs';
import { ProveedorDTO } from '../dto/proveedor.dto';
import 'rxjs/add/operator/toPromise';

/**
 * servicio encargado de llamar los rest de gestionar proveedor
 */
@Injectable({
    providedIn: 'root'
  })
export class GestionarProveedorService  extends AbstractService{

    /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    super(injector);
  }

  /**
   * metodo que llama a crear del rest
   * @param proveedorDTO , proveedor nuevo a crear
   */
  public crearProveedor(proveedorDTO: ProveedorDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crear', proveedorDTO);
  }

  /**
   * metodo que llama al metodo editar proveedor del rest
   * @param nuevoMonto nuevo monto a editar
   * @param nombre nuevo nombre a editar
   * @param proveedorDTO , proveedor a editar
   */
  public editarProveedor(nuevoMonto:number, nombre: string,  proveedorDTO: ProveedorDTO): Observable<any>{
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificar', proveedorDTO);
  }

  /**
   * metodo que llama a modificar estado del proveedor
   * @param proveedorDTO a modificarle el estado
   */
  public modificarEstado(proveedorDTO: ProveedorDTO):Observable<any>{
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/cambiarEstado', proveedorDTO);
  }

  /**
   * 
   * @param id , id del comic a consultar
   */
  public consultarProveedor( id: string): Observable<any>{
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedor', id);
  }

  /**
   * metodo que llama consultar proveedores
   */
  public consultarProveedores(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarProveedor/consultarProveedores');
  }

}