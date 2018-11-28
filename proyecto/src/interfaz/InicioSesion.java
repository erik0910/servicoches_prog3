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
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Objetos.Producto;
import Objetos.USUARIO;


import java.awt.Toolkit;
import java.awt.Font;

public class InicioSesion extends JFrame implements ActionListener, Runnable{

	Calendar calendario=Calendar.getInstance();
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblHora;
	Thread thread;
	ArrayList<USUARIO>users;
	public InicioSesion() {users=new ArrayList<>();
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
	public static void meterdatos() {
		try {
			FileWriter e=new FileWriter("usuarios.csv");
			
			e.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new InicioSesion();
	}
	//todavia necesita crearse la base de datos para poder hacerlo correctamente


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
