package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Controlador;
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
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/*Clase Vista
 * Presenta el modelo en un formato adecuado para 
 * interactuar (mediante una interfaz de usuario)
 * @author LuisMario
 * @version 1.0
 */
public class Vista extends JFrame {

	private JPanel contentPane;
	private DefaultListModel lcoches;
	private DefaultListModel lclientes;
	private JButton btnAlquilar;
	private JScrollPane scrollPaneCoches;
	private JList listCoches;
	private JScrollPane scrollPaneClientes;
	private JList listClientes;
	private JTextField textFieldCochesAlquilados;
	private JPanel panelRealizarAlquiler;
	private JPanel panelMostrarAlquileres;
	private JTable tableAlquileres;
	private DefaultTableModel modelo;
	private static CarDAO car;
	private static ClientDAO client; 
	private static RentalDAO rental;

	//getters y setters de los componentes del JFrame
	public JTextField getTextFieldCochesAlquilados() {
		return textFieldCochesAlquilados;
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


	public DefaultListModel getLCoches() {
		return lcoches;
	}

	public DefaultListModel getLClientes() {
		return lclientes;
	}
	
	public DefaultTableModel getModelo() {
		return modelo;
	}
	
	public JTable getTableAlquileres() {
		return tableAlquileres;
	}
	
	/*
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					car = new CarDAO();
					client = new ClientDAO(); 
					rental = new RentalDAO();
					
					Vista frame = new Vista();
					frame.setVisible(true);
					
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

	//componentes de la vista
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
		
		JLabel lblCoches = new JLabel("Coches Disponibles");
		lblCoches.setBounds(36, 26, 120, 14);
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
		lblNCochesAlquilados.setBounds(101, 378, 133, 14);
		panelMostrarAlquileres.add(lblNCochesAlquilados);
		
		JLabel lblAlquileres = new JLabel("Alquileres");
		lblAlquileres.setBounds(160, 28, 74, 14);
		panelMostrarAlquileres.add(lblAlquileres);
		
		textFieldCochesAlquilados = new JTextField();
		textFieldCochesAlquilados.setEditable(false);
		textFieldCochesAlquilados.setBounds(246, 375, 31, 20);
		panelMostrarAlquileres.add(textFieldCochesAlquilados);
		textFieldCochesAlquilados.setColumns(10);
		
		int totalAlquilados = rental.cuentaAlquilados();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 342, 277);
		panelMostrarAlquileres.add(scrollPane);
		
		tableAlquileres = new JTable();
		scrollPane.setViewportView(tableAlquileres);
		
		//nombres de las columnas
		String[] titulos ={"Matricula", "Dni", "FechaInicio", "FechaFin"};
		String filas[] = new String[4];
		
        modelo = new DefaultTableModel(null, titulos);
        tableAlquileres.setModel(modelo);
        
		/*cambiamos el codigo del JTable al controlador
		 * for (Alquiler alquiler : RentalDAO.listaAlquileres()) {
			
			filas[0]= alquiler.getMatricula();
			filas[1]= alquiler.getDni();
			filas[2]= alquiler.getFechaInicio();
			filas[3]= alquiler.getFechaFin();
			modelo.addRow(filas)
		}*/
        
	}
}
