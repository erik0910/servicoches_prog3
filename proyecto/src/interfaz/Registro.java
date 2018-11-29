package interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Objetos.USUARIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import bd.BaseDeDatos;
public class Registro extends JFrame implements ActionListener{
	private static JTextField textField;
	protected static ArrayList<USUARIO>p1=new ArrayList<>();
	private static JPasswordField passwordField;
	private Connection c;
	private Statement st;
	protected int id=0;
	JButton btnRegistrar ;
	public Registro() {
		setSize(new Dimension(900, 900));
		setPreferredSize(getSize());
		pack(); 
		getContentPane().setLayout(null);
		//recogemos todos los usuarios 
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
		c = BaseDeDatos.iniciar();
		st = BaseDeDatos.usarBD(c);
		p1=BaseDeDatos.cargaUsuario(c, st);
		
	}

	//metodo que compara los usuarioa anteriores para que no se puedan crear varios con el mismo nombre
	public boolean comparar() {
		String nombre=textField.getText();
		for (USUARIO usuario : p1) {
			if(nombre.equals(usuario.getNombre())) {return false;}
		//para obtener ademas el id del ultimmol usuario regustrado en la tabla 
		id=BaseDeDatos.idUsuario(c, st, usuario.getNombre())+1;
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String contra=String.valueOf(passwordField.getPassword());
		System.out.println(contra);
		if(comparar()) {
			int idReal=id-1;
			System.out.println(idReal);
		USUARIO u=new USUARIO(textField.getText(),contra , 0);
		BaseDeDatos.insertarUsuarios(st, u,id);
		BaseDeDatos.cerrarBD(c, st);
		new  InicioSesion();
		this.dispose();
		}
	
		
	}
}
