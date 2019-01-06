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
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
public class Registro extends JFrame implements ActionListener{
	private static JTextField textField;
	protected static ArrayList<USUARIO>p1=new ArrayList<>();
	private static JPasswordField passwordField;
	private Connection c;
	private Statement st;
	protected int id=0;
	JButton btnRegistrar ;
	public Registro() {
		getContentPane().setBackground(Color.BLACK);
		setSize(new Dimension(900, 900));
		setPreferredSize(getSize());
		pack(); 
		getContentPane().setLayout(null);
		//recogemos todos los usuarios 
		textField = new JTextField();
		textField.setBounds(354, 296, 373, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblNombre.setBounds(101, 296, 138, 39);
		getContentPane().add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblContrasea.setBounds(101, 435, 188, 39);
		getContentPane().add(lblContrasea);
		
		 btnRegistrar = new JButton("Registrar");
		 btnRegistrar.setFont(new Font("Baskerville Old Face", Font.PLAIN, 26));
		btnRegistrar.setBounds(337, 573, 197, 47);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(354, 436, 373, 42);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("P\u00E1gina de Registro\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 48));
		lblNewLabel.setBounds(86, 48, 373, 103);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 689, 882, 164);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Erik Martinez Iba\u00F1ez");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(681, 61, 189, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Xabier Galende Echevarr\u00EDa");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(643, 106, 227, 26);
		panel.add(lblNewLabel_2);
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
