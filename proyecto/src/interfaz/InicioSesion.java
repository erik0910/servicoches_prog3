package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.omg.CORBA.BAD_CONTEXT;

import Objetos.Producto;
import Objetos.USUARIO;


import java.awt.Toolkit;
import java.awt.Font;
import bd.BaseDeDatos;
import java.awt.Color;
import javax.swing.JPanel;
public class InicioSesion extends JFrame implements ActionListener, Runnable{
	//para mostrar la ohra al usuario todavia no esta seguro de que se valla a usar
	Calendar calendario=Calendar.getInstance();
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton botonIniciar;
	private JButton botonInvitado;
	private JButton botonRegistrar;
	private JLabel lblHora;
	//hilo que se usara futuramente para mejorar la imagen de la interfaz 
	Thread thread;
	//contenedor de los uusarios contenidos en la base de datos
	ArrayList<USUARIO>users;
	//Base de datos 
	Connection con;
	Statement st;
	
	private JMenuBar menuBar;
	private JMenu menuPrincipal;
	private JMenuItem m1, m2, m3, m4, m5;
	
	
	public InicioSesion() {
		getContentPane().setBackground(Color.BLACK);
		

		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setForeground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		menuPrincipal= new JMenu("W");
		menuBar.add(menuPrincipal);
		m1=new JMenuItem("Tienda");
		m2= new JMenuItem("Catálogo");
		m3= new JMenuItem("Sobre nosotros...");
		m4= new JMenuItem("Donde encontrarnos");
		
		users=new ArrayList<>();
		thread=new Thread(this);
		thread.start();
		setTitle("Servi-coches tu app para hacer compras");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/imagenes/Volkswagen-e-Golf-600x400.jpg")));
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("SERVI-COCHES");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(530, 13, 240, 39);
		getContentPane().add(lblNewLabel);
		
		 botonIniciar = new JButton("INICIAR");
		 botonIniciar.addActionListener(this);
		botonIniciar.setBounds(47, 537, 197, 47);
		getContentPane().add(botonIniciar);
		
		 botonInvitado = new JButton("INVITADO");
		 botonInvitado.addActionListener(this);
		botonInvitado.setBounds(288, 537, 197, 47);
		getContentPane().add(botonInvitado);
		
		botonRegistrar = new JButton("REGISTRAR");
		botonRegistrar.addActionListener(this);
		botonRegistrar.setBounds(536, 537, 205, 47);
		getContentPane().add(botonRegistrar);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		labelNombre.setForeground(Color.LIGHT_GRAY);
		labelNombre.setBounds(47, 357, 152, 46);
		getContentPane().add(labelNombre);
		
		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		labelContraseña.setForeground(Color.LIGHT_GRAY);
		labelContraseña.setBounds(47, 442, 179, 39);
		getContentPane().add(labelContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 441, 503, 42);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(238, 358, 503, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(Color.DARK_GRAY);
		panelInferior.setBounds(0, 630, 782, 97);
		getContentPane().add(panelInferior);
		panelInferior.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Erik Martinez Iba\u00F1ez");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(620, 50, 150, 34);
		panelInferior.add(lblNewLabel_3);
		
		JLabel lblXabierGalendeEchevarra = new JLabel("Xabier Galende Echevarr\u00EDa");
		lblXabierGalendeEchevarra.setForeground(Color.WHITE);
		lblXabierGalendeEchevarra.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblXabierGalendeEchevarra.setBounds(578, 39, 192, 16);
		panelInferior.add(lblXabierGalendeEchevarra);
		
		lblHora = new JLabel(""+calendario.getTime());
		lblHora.setBounds(58, 28, 249, 39);
		panelInferior.add(lblHora);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel arrayImagen = new JPanel();
		arrayImagen.setBounds(194, 120, 380, 144);
		getContentPane().add(arrayImagen);
		
		JButton imagenAnterior = new JButton("<");
		imagenAnterior.setBounds(81, 175, 97, 25);
		getContentPane().add(imagenAnterior);
		
		JButton imagenSiguiente = new JButton(">");
		imagenSiguiente.setBounds(597, 175, 97, 25);
		getContentPane().add(imagenSiguiente);
		//inicaianodo la base de datos
		con=BaseDeDatos.iniciar();
		 st=BaseDeDatos.usarBD(con);
		 //metemos los datos
		 users= BaseDeDatos.cargaUsuario(con, st);
		 //por mania lo meto en le propio constructor las caracteristacaas del la ventana
	setVisible(true);
	setLocationRelativeTo(null);
	setSize(800, 800);
	setPreferredSize(getSize());
	pack();
	
	}
	//esto unicamente para poder probar antes de que mi compañero haga la base de datos
	public void leerFichero() {
		try {
			FileReader a=new FileReader("usuarios.csv");
			BufferedReader b=new BufferedReader(a);
			String linea=null;
			while((linea=b.readLine())!=null) {
				int i=0;
				System.out.println(linea);
				String ac[]=linea.split(";");
			USUARIO p=new USUARIO(ac[0], ac[1], Integer.parseInt(ac[2]));}
			b.close();
			a.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	//compara si el usuario existe o no
	public boolean compara() {
		for (USUARIO usuario : users) {
			if(usuario.getNombre().equals(textField.getText())&& 
			usuario.getContra().equals(String.valueOf(passwordField.getPassword()))) {
			return  true;
			}
		}
		return false;
	}		
	//todavia necesita crearse la base de datos para poder hacerlo correctamente


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object j=arg0.getSource();
		if(j==botonIniciar) {
			if(compara()) {
				System.out.println("te has metido a la pagina principal");
				this.dispose();
			}else {System.out.println("contraseña incorrecta");}
			}else if(j==botonInvitado){
				System.out.println("modo invitado");
				this.dispose();
				}else {
				new Registro();	
				this.dispose();
				}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
