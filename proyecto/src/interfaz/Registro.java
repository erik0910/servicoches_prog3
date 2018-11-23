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
	private JTextField textField;
	ArrayList<USUARIO>p1;
	private JPasswordField passwordField;
	public Registro() {
		setSize(new Dimension(900, 900));
		setPreferredSize(getSize());
		pack(); 
		getContentPane().setLayout(null);
		p1=new ArrayList<>();
		
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(272, 552, 197, 47);
		getContentPane().add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(285, 379, 373, 42);
		getContentPane().add(passwordField);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new Registro();
	}
	public static void meterdatos(USUARIO usuario) {
		try {
			FileWriter e=new FileWriter("usuarios.csv");
			
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
				int i=0;
				System.out.println(linea);
				String ac[]=linea.split(";");
			USUARIO p=new USUARIO(ac[0], ac[1], Integer.parseInt(ac[2]));
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
	public boolean compararContra() {
		for (USUARIO usuario : p1) {
			if(usuario.equals(textField.getText())) {return false;}
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(compararContra()) {
			USUARIO usuario=new USUARIO(textField.getText(), passwordField.getText(), 0);
			p1.add(usuario);
		meterdatos(usuario);
		new  InicioSesion();
		this.dispose();
		}
		JOptionPane.showConfirmDialog(null, "el usuario ya esta por favor cambie de nombre");
		
	}
}
