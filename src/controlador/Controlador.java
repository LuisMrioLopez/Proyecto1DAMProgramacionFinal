package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import modelo.Alquiler;
import modelo.CarDAO;
import modelo.ClientDAO;
import modelo.Cliente;
import modelo.Coche;
import modelo.RentalDAO;
import vista.Vista;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Controlador implements ActionListener {
	private Vista vista;
	private CarDAO car;
	private ClientDAO client;
	private RentalDAO rental;
	
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
			if (e.getActionCommand().equals("Alquilar")){
				alquiler();
			}
		}
		
		//registra los eventos de la vista
		public void actionListener(ActionListener escuchador){
			vista.getBtnAlquilar().addActionListener(escuchador);
		}
	
	public void rellenaCoches(){
		List<Coche> c = car.getListaCoches();
		for (Coche coche : c) {
			vista.getLCoches().addElement(coche);
		}		
	}
	
	public void rellenaClientes(){
		List<Cliente> c = client.getListaClientes();
		for (Cliente cliente : c) {
			vista.getLClientes().addElement(cliente);
		}	
	}
	
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
	
	public void alquiler(){
		Date fecha = new Date();
		System.out.println(fecha);
		System.out.println(fecha.getDay());
		String f = String.valueOf(fecha.getDay()) + "/" + String.valueOf(fecha.getMonth()) + "/" + String.valueOf(fecha.getYear());
		Coche coche = (Coche) vista.getListCoches().getSelectedValue();
		Cliente cliente = (Cliente) vista.getListClientes().getSelectedValue();
		Alquiler alquiler = new Alquiler(coche.getMatricula(), cliente.getDni(), f, null);
		String filas[] = new String[4] ;
		filas[0]= alquiler.getMatricula();
		filas[1]= alquiler.getDni();
		filas[2]= alquiler.getFechaInicio();
		filas[3]= alquiler.getFechaFin();
		vista.getModelo().addRow(filas);
		
	}
	
	
}
