package interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Objetos.USUARIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Registro extends JFrame implements ActionListener{
	private static JTextField textField;
	protected static ArrayList<USUARIO>p1=new ArrayList<>();
	private static JPasswordField passwordField;
	JButton btnRegistrar ;
	public Registro() {
		setSize(new Dimension(900, 900));
		setPreferredSize(getSize());
		pack(); 
		getContentPane().setLayout(null);
		//recogemos todos los usuarios 
		leerFichero();
		textField = new JTextField();
		textField.setBounds(285, 203, 373, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(51, 206, 138, 39);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(51, 382, 188, 39);
		getContentPane().add(lblContrasea);
		
		 btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(272, 552, 197, 47);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 379, 373, 42);
		getContentPane().add(passwordField);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new Registro();
	}
	public static void meterdatos() {
		try {
			FileWriter e=new FileWriter("usuarios.csv");
			String contra=String.valueOf(passwordField.getPassword());
			USUARIO p=new USUARIO(textField.getText(),contra,0);
			p1.add(p);
			for (USUARIO usuario : p1) {
				e.write(usuario.toString()+"\n");
			}
			e.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void leerFichero() {
		try {
			FileReader a=new FileReader("usuarios.csv");
			BufferedReader b=new BufferedReader(a);
			String linea=null;
			
			while((linea=b.readLine())!=null) {
				System.out.println("entra");
				System.out.println(linea);
				String ac[]=linea.split(";");
				
			USUARIO p=new USUARIO(ac[0], ac[1], Double.parseDouble(ac[2]));
			p1.add(p);}
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
	//metodo que compara los usuarioa anteriores para que no se puedan crear varios con el mismo nombre
	public boolean comparar() {
		String nombre=textField.getText();
		for (USUARIO usuario : p1) {
			if(nombre.equals(usuario.getNombre())) {return false;}
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String contra=String.valueOf(passwordField.getPassword());
		System.out.println(contra);
		if(comparar()) {
		meterdatos();
		new  InicioSesion();
		this.dispose();
		}
	//	JOptionPane.showConfirmDialog(null, "el usuario ya esta por favor cambie de nombre");
		
	}
}
