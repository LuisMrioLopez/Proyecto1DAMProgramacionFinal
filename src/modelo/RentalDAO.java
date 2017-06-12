package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO implements IRentalDAO{

	private static Connection conexion = Conexion.getInstance();
	
	public List<Alquiler> getListaAlquileres() {
		List<Alquiler> listaAlquileres = new ArrayList<>();
		String sql = "SELECT * FROM alquiler";
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
	
	public static void main(String[] args) {
		RentalDAO rentalDao =  new RentalDAO();
		System.out.println(rentalDao.getListaAlquileres());
	}

}
