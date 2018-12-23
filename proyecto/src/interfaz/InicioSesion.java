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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
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
		lblNewLabel.setBounds(536, 13, 240, 39);
		getContentPane().add(lblNewLabel);
		
		 btnNewButton = new JButton("INICAR");
		 btnNewButton.addActionListener(this);
		btnNewButton.setBounds(47, 537, 197, 47);
		getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("INVITADO");
		 btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(288, 537, 197, 47);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(536, 537, 205, 47);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(47, 357, 152, 46);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(47, 442, 179, 39);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(238, 441, 503, 42);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(238, 358, 503, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblHora = new JLabel(""+calendario.getTime());
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHora.setBounds(515, 0, 249, 39);
		getContentPane().add(lblHora);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 630, 782, 97);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Erik Martinez Iba\u00F1ez");
		lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(620, 50, 150, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblXabierGalendeEchevarra = new JLabel("Xabier Galende Echevarr\u00EDa");
		lblXabierGalendeEchevarra.setFont(new Font("Century Schoolbook", Font.PLAIN, 15));
		lblXabierGalendeEchevarra.setBounds(578, 39, 192, 16);
		panel.add(lblXabierGalendeEchevarra);
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
		if(j==btnNewButton) {
			if(compara()) {
				System.out.println("te has metido a la pagina principal");
				this.dispose();
			}else {System.out.println("contraseña incorrecta");}
			}else if(j==btnNewButton_1){
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
