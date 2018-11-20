package interfaz;

import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Registro extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public Registro() {
		setSize(new Dimension(900, 900));
		setPreferredSize(getSize());
		pack(); 
		getContentPane().setLayout(null);
		
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 376, 373, 45);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(272, 552, 197, 47);
		getContentPane().add(btnRegistrar);
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new Registro()
		;
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
}
