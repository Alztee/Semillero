
/**
 * clase que modela un proveedor
 */
export class ProveedorDTO{

    /**
     * nombre del proveedor
     */
    public nombre: string;

    /**
     * id del proveedor
     */
    public id: string;

    /**
     * direccion del proveedor
     */
    public direccion: string;

    /**
     * fecha afiliacion del proveedor
     */
    public fechaCreacion: Date;

    /**
     * estado del proveedor
     */
    public estado: boolean;

    /**
     * credito del proveedor
     */
    public montoCredito: number;

    /**
     * cedula del proveedor
     */
    public cedula: string;
}