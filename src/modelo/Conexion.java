package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Clase Conexion
 *Crea una conexion con la base de datos
 *mediante un patr�n singleton
 * @author LuisMario
 * @version 1.0
 */
public class Conexion {
private static Connection conexion = null;
	
	private Conexion(){
		//creamos el objeto conexion (Connection)
		try {
			Class.forName("org.sqlite.JDBC");
			try {
				conexion = DriverManager.
						getConnection("jdbc:sqlite:BD/luis.bd");
			} catch (SQLException e) {
				System.out.println("Error al acceso de la base de datos");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc no encotrador");
		}
	}
	
	public static Connection getInstance(){
		if (conexion == null)
			new Conexion();
		return conexion;
	}
	public static void main(String[] args) {
		Conexion.getInstance();
	}
}
