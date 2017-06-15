package modelo;

import java.util.List;

/*Interface IRentalDAO
 *Interface que tiene los metodos que mas tarde
 *vamos a implementar en la clase RentalDAO
 * @author LuisMario
 * @version 1.0
 */
public interface IRentalDAO {
	
	List<Alquiler> getListaAlquileres();
	
	boolean addAlquiler (Alquiler alquiler);
	
	int cuentaAlquilados();
	
}
