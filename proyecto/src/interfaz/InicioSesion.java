package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InicioSesion extends JFrame implements ActionListener{
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	public InicioSesion() {
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("SERVI-COCHES");
		lblNewLabel.setBounds(299, 33, 240, 39);
		getContentPane().add(lblNewLabel);
		
		 btnNewButton = new JButton("INICAR");
		 btnNewButton.addActionListener(this);
		btnNewButton.setBounds(65, 428, 197, 47);
		getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("INVITADO");
		 btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(337, 428, 197, 47);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(578, 428, 227, 47);
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
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//todavia necesita crearse la base de datos para poder hacerlo correctamente
	@Override
	public void actionPerformed(ActionEvent e) {
		

		
	}
}
