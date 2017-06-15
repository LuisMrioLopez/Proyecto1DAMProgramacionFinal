package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import modelo.Alquiler;
import modelo.CarDAO;
import modelo.ClientDAO;
import modelo.Cliente;
import modelo.RentalDAO;
import vista.Vista;

/*Clase Controlador
 * Responde a eventos e invoca peticiones al modelo cuando
 * se hace alguna solicitud sobre los datos
 * hace de intermediario entre la vista y el modelo
 * @author LuisMario
 * @version 1.0
 */
public class Controlador implements ActionListener {
	private Vista vista;
	private CarDAO car;
	private ClientDAO client;
	private RentalDAO rental;
	private List<Alquiler> listaAlquileres = new RentalDAO().getListaAlquileres();

	
	public Controlador(Vista vista, CarDAO car, ClientDAO client, RentalDAO rental) {
		super();
		this.vista = vista;
		this.car = car;
		this.client = client;
		this.rental = rental;
		actionListener(this);
	}
	//respuesta a los eventos de la vista
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Alquilar")){//funcion que tiene el boton alquilar
			alquiler();
				
		}
	}
	
	//registra los eventos de la vista
	public void actionListener(ActionListener escuchador){
		vista.getBtnAlquilar().addActionListener(escuchador);//boton que realiza el alquiler
	}
	
	//rellena la lista coches que tenemos en la vista recorriendo la lista del DAO
	public void rellenaCoches(){
		List<String> c = car.getListaCochesDisponibles();
		for (String coche : c) {
			vista.getLCoches().addElement(coche);
		}		
	}
	
	//rellena la lista clientes que tenemos en la vista recorriendo la lista del DAO
	public void rellenaClientes(){
		List<Cliente> c = client.getListaClientes();
		for (Cliente cliente : c) {
			vista.getLClientes().addElement(cliente);
		}	
	}
	//rellena la tabla de la vista recorriendo la lista de su clase DAO(de la base de datos) y la añadimos al modelo
	public void rellenaAlquiler(){

		List<Alquiler> a = rental.getListaAlquileres();
		for (Alquiler alquiler : a) {
			String filas[] = new String[4] ;
			filas[0]= alquiler.getMatricula();
			filas[1]= alquiler.getDni();
			filas[2]= alquiler.getFechaInicio();
			filas[3]= alquiler.getFechaFin();
			vista.getModelo().addRow(filas);
			
		}		
		
	}
	
	
	/*funcion encargada de realizar el alquiler 
	* ademas los añade a la base de datos,
	* muestra los alquileres en el Jtable de la vista,
	* actualiza la lista de coches disponibles
	* y muestra los coches alquilados en la vista
	* @author LuisMario
	* @version 1.0*/
	private void alquiler(){
		//damos formato a la fecha del sistema convertida a String
		Calendar fecha = new GregorianCalendar();
		System.out.println(fecha);
		String f = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(fecha.get(Calendar.MONTH)) + "/" + String.valueOf(fecha.get(Calendar.YEAR));
		
		//Seleccionamos un coche(matricula) y un cliente para realizar el alquiler
		String matricula = (String) vista.getListCoches().getSelectedValue();
		Cliente cliente = (Cliente) vista.getListClientes().getSelectedValue();
		Alquiler alquiler = new Alquiler(matricula, cliente.getDni(), f, null);
		//llama al metodo del DAO del alquiler que añade el alquiler a la base de datos
		rental.addAlquiler(alquiler);
		
		//nos traemos de la vista el codigo del Jtable
		String filas[] = new String[4];
		filas[0]= alquiler.getMatricula();
		filas[1]= alquiler.getDni();
		filas[2]= alquiler.getFechaInicio();
		filas[3]= alquiler.getFechaFin();
		vista.getModelo().addRow(filas);
		listaAlquileres.add(alquiler);
		
		/*elimina el coche seleccionado de la lista de coches 
		*disponibles mediante borrar todos los elementos de la lista*/
		vista.getLcoches().removeAllElements();
		
		/*actualiza la lista de coches disponibles utilizando de nuevo
		*el metodo de rellenar coches*/
		rellenaCoches();
		
		/*llamamos el metodo cuentaAlquilados que nos devuelve un numero
		*entero que son los coches alquilados*/
		int totalAlquilados = rental.cuentaAlquilados();
		
		//ese numero lo mostramos en la vista
		vista.getTextFieldCochesAlquilados().setText(String.valueOf(totalAlquilados));
		
	}
	
}
