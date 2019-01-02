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

public class Polo extends JFrame{
	private JMenuBar menuBar;
	private JMenu menuPrincipal;
	private JMenuItem m1, m2, m3, m4, m5;
	public Polo() {
		//caractaresiticas principales de nuestra ventana
	setVisible(true);
		setSize(1500, 1000);
			setLocationRelativeTo(null);
				getContentPane().setLayout(null);
		//menu bar añadiendo los items
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
			menuPrincipal.add(m4);
		//los botones y labels necesarios para nuestra aplicacion
		JLabel lblNewLabel = new JLabel("FOTO");
		lblNewLabel.setBounds(544, 101, 188, 118);
		getContentPane().add(lblNewLabel);
		
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
				
	}		
	
}
