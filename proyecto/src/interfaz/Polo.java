package interfaz;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Polo extends JFrame{
	private JMenuBar menuBar;
	private JMenu menuPrincipal;
	private JMenuItem m1, m2, m3, m4, m5;
<<<<<<< HEAD
	private JPanel panel;
	
	
=======
>>>>>>> branch 'master' of https://github.com/erik0910/servicoches_prog3.git
	public Polo() {
<<<<<<< HEAD
		getContentPane().setBackground(Color.BLACK);
		
=======
		//caractaresiticas principales de nuestra ventana
>>>>>>> branch 'master' of https://github.com/erik0910/servicoches_prog3.git
	setVisible(true);
<<<<<<< HEAD
	setSize(1000, 1000);
	setLocationRelativeTo(null);
		
=======
		setSize(1500, 1000);
			setLocationRelativeTo(null);
				getContentPane().setLayout(null);
		//menu bar añadiendo los items
>>>>>>> branch 'master' of https://github.com/erik0910/servicoches_prog3.git
		menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		menuPrincipal= new JMenu("W");
			menuBar.add(menuPrincipal);
		m1=new JMenuItem("Tienda");
			menuPrincipal.add(m1);
		m2= new JMenuItem("Catálogo");
			menuPrincipal.add(m2);
		m3= new JMenuItem("Sobre nosotros...");
			menuPrincipal.add(m3);
		m4= new JMenuItem("Donde encontrarnos");
<<<<<<< HEAD
		
		menuPrincipal.add(m1);
		menuPrincipal.add(m2);
		menuPrincipal.add(m3);
		menuPrincipal.add(m4);
		
		
		getContentPane().setLayout(null);
=======
			menuPrincipal.add(m4);
		//los botones y labels necesarios para nuestra aplicacion
		JLabel lblNewLabel = new JLabel("FOTO");
		lblNewLabel.setBounds(544, 101, 188, 118);
		getContentPane().add(lblNewLabel);
>>>>>>> branch 'master' of https://github.com/erik0910/servicoches_prog3.git
		
		JButton btnComprar = new JButton("A\u00D1ADIR AL CARRO");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnComprar.setBounds(1324, 13, 146, 25);
		getContentPane().add(btnComprar);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO");
		lblNewLabel_2.setBounds(1136, 819, 56, 16);
		getContentPane().add(lblNewLabel_2);
<<<<<<< HEAD
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 788, 982, 139);
		getContentPane().add(panel);
		
		JButton btnAadirALa = new JButton("A\u00F1adir a la cesta");
		btnAadirALa.setBounds(804, 13, 166, 41);
		getContentPane().add(btnAadirALa);
		
		JLabel lblNewLabel = new JLabel("Dise\u00F1o: \r\nSu estilo no esconde nada. \r\nEl Polo es atrevido y muy fresco, diferente a todo lo que conoces.");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 591, 970, 48);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confort: \r\nEn viajes largos, estar\u00E1s relajado gracias a su c\u00F3modo equipamiento. ");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 652, 958, 41);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Y adem\u00E1s tiene el avanzado sistema de aire acondicionado opcional Climatronic.");
		lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 687, 958, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Medidas: Largo 4,05m. Ancho 1,95m. Alto 1,46m.     Capacidad del maletero: 349-1125 L");
		lblNewLabel_4.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 734, 940, 41);
		getContentPane().add(lblNewLabel_4);
		
		
		
		
		
=======
				
>>>>>>> branch 'master' of https://github.com/erik0910/servicoches_prog3.git
	}		
	
}
