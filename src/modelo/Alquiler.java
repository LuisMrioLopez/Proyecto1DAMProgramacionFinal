package modelo;

/*Clase Alquiler
 *Clase del DTO de la tabla Alquiler
 *que crea el constructor y sus 
 *correspondientes getters y setters
 *@author LuisMario
 *@version 1.0
 */
public class Alquiler {
	private String matricula;
	private String dni;
	private String fechaInicio;
	private String fechaFin;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Alquiler(String matricula, String dni, String fechaInicio, String fechaFin) {
		super();
		this.matricula = matricula;
		this.dni = dni;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	@Override
	public String toString() {
		return matricula + ", " + dni + ", " + fechaInicio + ", " + fechaFin;
	}

	
}
