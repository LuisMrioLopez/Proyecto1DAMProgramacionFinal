package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*Clase RentalDAO
 * clase donde vamos a realizar una conexion con la base de datos
 * e implementamos los metodos de la interface IRentalDAO
 * @author LuisMario
 * @version 1.0
 */
public class RentalDAO implements IRentalDAO{

	private static Connection conexion = Conexion.getInstance();
	
	//metodo que nos devuelve una lista de alquileres mediante una consulta con la base de datos
	@Override
	public List<Alquiler> getListaAlquileres() {
		List<Alquiler> listaAlquileres = new ArrayList<>();
		String sql = "SELECT * from alquiler";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String matricula = resulset.getString("matricula");
				String dni = resulset.getString("dni");
				String fechaInicio = resulset.getString("fechaInicio");
				String fechaFin = resulset.getString("fechaFin");
				Alquiler alquiler = new Alquiler(matricula, dni, fechaInicio, fechaFin);
				listaAlquileres.add(alquiler);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la base de datos");
		}
		return listaAlquileres;
	}
	
	//metodo que añade un alquiler a la base de datos
	@Override
	public boolean addAlquiler(Alquiler alquiler) {
		int resultado = 0;
		String sql = "INSERT INTO alquiler VALUES (?,?,?,?)";
		try {
			PreparedStatement pStatement = conexion.prepareStatement(sql);
			pStatement.setString(1, alquiler.getMatricula());
			pStatement.setString(2, alquiler.getDni());
			pStatement.setString(3, alquiler.getFechaInicio());
			pStatement.setString(4, alquiler.getFechaFin());
			resultado = pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error en la inserccion del alquiler");
		}
		
		return resultado != 0;
	}
	//metodo que nos devuelve mediante la funcion sql Count el numero de coches alquilados
	public int cuentaAlquilados(){
		int numero = 0;
		String sql = "SELECT count(*) FROM alquiler where fechaFin is null";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				numero = resulset.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la base de datos");
		}
		return numero;
		
	}
	
	public static void main(String[] args) {
		RentalDAO rentalDao = new RentalDAO();
		System.out.println(rentalDao.getListaAlquileres());
	}


}
