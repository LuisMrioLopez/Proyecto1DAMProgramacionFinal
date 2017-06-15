package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*Clase CarDAO
 * clase donde vamos a realizar una conexion con la base de datos
 * e implementamos los metodos de la interface ICarDAO
 * @author LuisMario
 * @version 1.0
 */
public class CarDAO implements ICarDAO{

private static Connection conexion = Conexion.getInstance();
	
	/*metodo que nos devuelve una lista de coches(matriculas)
	*que estan disponibles mediante una vista con la base de datos*/
	@Override
	public List<String> getListaCochesDisponibles() {//es una lista de string
		List<String> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches_disponibles";//utilizamos la vista de la base de datos
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String matricula = resulset.getString("matricula");

				listaCoches.add(matricula);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la base de datos");
		}
		return listaCoches;
	}
	
	public static void main(String[] args) {
		CarDAO carDao =  new CarDAO();
		System.out.println(carDao.getListaCochesDisponibles());
	}
}
