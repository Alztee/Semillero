/**
 * clase de prueba para realizar el taller sesion 2 angular
 * simula un libro
 */
export class LibroDTO {

    /**
     * id del libro
     */
    public  id: number;
    /**
     * nombre del libro
     */
    public nombre: string;
    /**
     * editorial del libro
     */
    public editorial : string;
    /**
     * tamtica del libro
     */
    public tematica:string;
    /**
     * precio del libro
     */
    public precio: number;
    /**
     * autores del libro
     */
    public autores: string;
    /**
     * si el libro es a color o no
     */
    public aColor: boolean;
    /**
     * fecha de publicacion
     */
    public fecha: Date;
    /**
     * estado del libro
     */
    public estado: boolean;
}