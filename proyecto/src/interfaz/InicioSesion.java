package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel CONTRA ;
	JLabel ID;
	public InicioSesion() {
		users=new ArrayList<>();
		thread=new Thread(this);
		thread.start();
		setTitle("Servi-coches tu app para hacer compras");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/imagenes/Volkswagen-e-Golf-600x400.jpg")));
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("SERVI-COCHES");
		lblNewLabel.setBounds(264, 66, 240, 39);
		getContentPane().add(lblNewLabel);
		
		 btnNewButton = new JButton("INICAR");
		 btnNewButton.addActionListener(this);
		btnNewButton.setBounds(31, 428, 197, 47);
		getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("INVITADO");
		 btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(264, 428, 197, 47);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(515, 428, 227, 47);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(65, 202, 138, 39);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setBounds(65, 294, 179, 39);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 292, 350, 42);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(253, 199, 350, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblHora = new JLabel(""+calendario.getTime());
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHora.setBounds(515, 0, 249, 39);
		getContentPane().add(lblHora);
		
		CONTRA = new JLabel("CONTRASE\u00D1A INCORRECTA");
		CONTRA.setFont(new Font("Tahoma", Font.PLAIN, 26));
		CONTRA.setForeground(Color.RED);
		CONTRA.setBounds(253, 249, 397, 39);
		CONTRA.setVisible(false);
		getContentPane().add(CONTRA);
		
		ID = new JLabel("ID INCORRECTO");
		ID.setFont(new Font("Tahoma", Font.PLAIN, 26));
		ID.setForeground(Color.RED);
		ID.setBounds(253, 150, 333, 39);
		ID.setVisible(false);
		getContentPane().add(ID);
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
	//compara si el usuario existe o no y si es el caso de 
	//que alguna de las dos esta mal se mostrara mediante los labeles cuales estan mal
	public boolean compara() {
		for (USUARIO usuario : users) {
			if(usuario.getNombre().equals(textField.getText())&& 
			usuario.getContra().equals(String.valueOf(passwordField.getPassword()))) {
			return  true;
			}else if(usuario.getContra().equals(String.valueOf(passwordField.getPassword()))) {
				System.out.println(1);
				ID.setVisible(true);
			}
			else {
				CONTRA.setVisible(true);
			}	
		}
		return false;
	}		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object j=arg0.getSource();
		if(j==btnNewButton) {
			if(compara()) {
				new Polo();
				this.dispose();
			}
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
