package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Alquiler;
import modelo.CarDAO;
import modelo.ClientDAO;
import modelo.RentalDAO;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class Vista extends JFrame {

	private JPanel contentPane;
	private DefaultListModel lcoches;
	private DefaultListModel lclientes;
	private JButton btnAlquilar;
	private JTable tableAlquileres;
	private JScrollPane scrollPaneCoches;
	private JList listCoches;
	private JScrollPane scrollPaneClientes;
	private JList listClientes;
	private JTextField textFieldCochesAlquilados;
	private JTextField textFieldCochesDisponibles;
	private JPanel panelRealizarAlquiler;
	private JPanel panelMostrarAlquileres;
	private JTable table;
	private DefaultTableModel modelo;

	
	public JTextField getTextFieldCochesAlquilados() {
		return textFieldCochesAlquilados;
	}

	public JTextField getTextFieldCochesDisponibles() {
		return textFieldCochesDisponibles;
	}

	public DefaultListModel getLcoches() {
		return lcoches;
	}

	public DefaultListModel getLclientes() {
		return lclientes;
	}

	public JButton getBtnAlquilar() {
		return btnAlquilar;
	}

	public JList getListCoches() {
		return listCoches;
	}

	public JList getListClientes() {
		return listClientes;
	}

	public JTable getTableAlquileres() {
		return tableAlquileres;
	}

	public DefaultListModel getLCoches() {
		return lcoches;
	}

	public void setLCoches(DefaultListModel lcoches) {
		this.lcoches = lcoches;
	}

	public DefaultListModel getLClientes() {
		return lclientes;
	}

	public void setLClientes(DefaultListModel lclientes) {
		this.lclientes = lclientes;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					
					CarDAO car = new CarDAO();
					ClientDAO client = new ClientDAO(); 
					RentalDAO rental = new RentalDAO();
					
					Controlador c = new Controlador(frame, car, client, rental);
					
					c.rellenaCoches();
					c.rellenaClientes();
					c.rellenaAlquiler();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelRealizarAlquiler = new JPanel();
		panelRealizarAlquiler.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelRealizarAlquiler.setBounds(10, 11, 371, 439);
		contentPane.add(panelRealizarAlquiler);
		panelRealizarAlquiler.setLayout(null);

		
		btnAlquilar = new JButton("Alquilar");
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlquilar.setBounds(136, 371, 89, 23);
		panelRealizarAlquiler.add(btnAlquilar);
		
		JLabel lblCoches = new JLabel("Coches");
		lblCoches.setBounds(67, 26, 46, 14);
		panelRealizarAlquiler.add(lblCoches);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(251, 26, 46, 14);
		panelRealizarAlquiler.add(lblClientes);
		
		scrollPaneCoches = new JScrollPane();
		scrollPaneCoches.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCoches.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCoches.setBounds(10, 70, 168, 277);
		panelRealizarAlquiler.add(scrollPaneCoches);
		
		listCoches = new JList();
		scrollPaneCoches.setViewportView(listCoches);
		lcoches = new DefaultListModel();
		listCoches.setModel(lcoches);
		
		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(193, 70, 168, 277);
		panelRealizarAlquiler.add(scrollPaneClientes);
		
		listClientes = new JList();
		scrollPaneClientes.setViewportView(listClientes);
		lclientes = new DefaultListModel();
		listClientes.setModel(lclientes);
		
		panelMostrarAlquileres = new JPanel();
		panelMostrarAlquileres.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMostrarAlquileres.setBounds(391, 11, 383, 439);
		contentPane.add(panelMostrarAlquileres);
		panelMostrarAlquileres.setLayout(null);
		
		
		
		
		JLabel lblNCochesAlquilados = new JLabel("N\u00BA coches alquilados");
		lblNCochesAlquilados.setBackground(Color.WHITE);
		lblNCochesAlquilados.setBounds(72, 359, 133, 14);
		panelMostrarAlquileres.add(lblNCochesAlquilados);
		
		JLabel lblNCochesDisponibles = new JLabel("N\u00BA coches disponibles");
		lblNCochesDisponibles.setBounds(72, 402, 133, 14);
		panelMostrarAlquileres.add(lblNCochesDisponibles);
		
		JLabel lblAlquileres = new JLabel("Alquileres");
		lblAlquileres.setBounds(160, 28, 74, 14);
		panelMostrarAlquileres.add(lblAlquileres);
		
		textFieldCochesAlquilados = new JTextField();
		textFieldCochesAlquilados.setEditable(false);
		textFieldCochesAlquilados.setBounds(215, 356, 86, 20);
		panelMostrarAlquileres.add(textFieldCochesAlquilados);
		textFieldCochesAlquilados.setColumns(10);
		
		textFieldCochesDisponibles = new JTextField();
		textFieldCochesDisponibles.setEditable(false);
		textFieldCochesDisponibles.setBounds(215, 399, 86, 20);
		panelMostrarAlquileres.add(textFieldCochesDisponibles);
		textFieldCochesDisponibles.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 72, 335, 222);
		panelMostrarAlquileres.add(scrollPane);
		
		/*DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		//table = new JTable();
		table.setModel(new DefaultTableModel(
			null,
			new String[] {
				"Matricula", "Dni", "FechaInicio", "FechaFin"
			}
		));
		scrollPane.setViewportView(table);
		int numCols = table.getModel().getColumnCount();

		Object [] fila = new Object[numCols]; 
		fila[0] = "unal";
		fila[1] = "420";
		fila[2] = "mundo";
		fila[3] = "mundo";
		
		((DefaultTableModel)table.getModel()).addRow(fila);*/
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		String[] titulos ={"Matricula", "Dni", "FechaInicio", "FechaFin"};
		String filas[] = new String[4] ;
		
		
        modelo = new DefaultTableModel(null, titulos);
	
		//Recorro la lista de la base de datos y añado cada personaje al modelo
		/*for (Alquiler alquiler : RentalDAO.listaAlquileres()) {
			
			filas[0]= alquiler.getMatricula();
			filas[1]= alquiler.getDni();
			filas[2]= alquiler.getFechaInicio();
			filas[3]= alquiler.getFechaFin();
			modelo.addRow(filas);
			
		}*/
		
		//le aplico el modelo
		table.setModel(modelo);
}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	
	
}
