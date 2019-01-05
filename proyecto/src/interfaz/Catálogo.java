package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Catálogo extends JFrame{
	public Catálogo() {
		getContentPane().setBackground(SystemColor.controlHighlight);
		getContentPane().setLayout(null);
		
		JLabel lblCatlogo = new JLabel("CAT\u00C1LOGO");
		lblCatlogo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
		lblCatlogo.setBounds(82, 28, 199, 58);
		getContentPane().add(lblCatlogo);
		
		JLabel lblPoloGasolina = new JLabel("POLO GASOLINA");
		lblPoloGasolina.setForeground(Color.BLACK);
		lblPoloGasolina.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblPoloGasolina.setBounds(82, 181, 141, 50);
		getContentPane().add(lblPoloGasolina);
		
		JLabel lblNewLabel = new JLabel("POLO DIESEL");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNewLabel.setBounds(477, 194, 104, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GOLF ALTA GAMA");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(82, 320, 142, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSAT FAMILIAR");
		lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(477, 323, 115, 24);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TOURAN");
		lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(82, 471, 115, 31);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TOUAREG 4X4");
		lblNewLabel_4.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(477, 474, 104, 24);
		getContentPane().add(lblNewLabel_4);
		
		JButton botonPoloGasolina = new JButton("");
		botonPoloGasolina.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/poloGasolina.jpg")));
		botonPoloGasolina.setBounds(244, 153, 157, 122);
		getContentPane().add(botonPoloGasolina);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/poloDiesel.jpg")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(666, 153, 150, 119);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/golf.jpg")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(244, 288, 157, 116);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/passatFamiliar.jpg")));
		btnNewButton_3.setBounds(666, 285, 150, 119);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/touareg.jpg")));
		btnNewButton_4.setBounds(666, 433, 150, 116);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Catálogo.class.getResource("/interfaz/touram.jpg")));
		btnNewButton_5.setBounds(244, 433, 157, 116);
		getContentPane().add(btnNewButton_5);
	}
	
	
	
	
	

	public static void main(String[] args) {
		

	}
}
