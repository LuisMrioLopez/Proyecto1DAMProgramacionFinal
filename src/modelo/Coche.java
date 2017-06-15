package modelo;

/*Clase Coche
 *Clase del DTO de la tabla Coche
 *que crea el constructor y sus 
 *correspondientes getters y setters
 * @author LuisMario
 * @version 1.0
 */
public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	
	public Coche(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return matricula + ", " + marca + ", " + modelo;
	
	}
	
}
