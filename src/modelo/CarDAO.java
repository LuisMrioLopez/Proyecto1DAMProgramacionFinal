package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements ICarDAO{

private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Coche> getListaCoches() {

		List<Coche> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches ORDER BY matricula";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String matricula = resulset.getString("matricula");
				String marca = resulset.getString("marca");
				String modelo = resulset.getString("modelo");
				Coche coche = new Coche(matricula, marca, modelo);
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la base de datos");
		}
		return listaCoches;
	}
	
	public static void main(String[] args) {
		CarDAO carDao =  new CarDAO();
		System.out.println(carDao.getListaCoches());
	}
}
