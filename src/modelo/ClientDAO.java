package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO{

	private static Connection conexion = Conexion.getInstance();
	
	@Override
	public List<Cliente> getListaClientes() {

		List<Cliente> listaClientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes ORDER BY dni";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String dni = resulset.getString("dni");
				String nombre = resulset.getString("nombre");
				String telefono = resulset.getString("telefono");
				Cliente cliente = new Cliente(dni, nombre, telefono);
				listaClientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la base de datos");
		}
		return listaClientes;
	}
	
	public static void main(String[] args) {
		ClientDAO clientDao =  new ClientDAO();
		System.out.println(clientDao.getListaClientes());
	}
}
