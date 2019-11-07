/**
 * GestionarComicRes.java
 */
package com.hbt.semillero.res;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina comic bean con el exterior <b>Caso de
 * Uso:<b>
 * 
 * @author Alzate Leon
 * @version 1.0
 */
@Path("/GestionarComic")
public class GestionarComicRes {

	/**
	 * variable que hace referencia a la interface
	 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;

	/**
	 * Metodo de prueba de la pagina web con wildfly
	 * 
	 * @author Azlate Leon
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo") // ruta de acceso
	@Produces // definir el tipo de dato que se va a devolver
	public String primerRes() {
		return "holi mundo";
	}

	/**
	 * 
	 * Metodo encargado de consultar un comic por su id 
	 * el id se especifica en el navegador usando un ?idComic=1
	 * 
	 * @author Alzate Leon
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
}
