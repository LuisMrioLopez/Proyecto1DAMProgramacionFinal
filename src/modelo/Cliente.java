package modelo;

/*Clase Cliente
 *Clase del DTO de la tabla Cliente
 *que crea el constructor y sus 
 *correspondientes getters y setters
 * @author LuisMario
 * @version 1.0
 */
public class Cliente {
	private String dni;
	private String nombre;
	private String telefono;
	

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Cliente(String dni, String nombre, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return dni + ", " + nombre;
	}
}
