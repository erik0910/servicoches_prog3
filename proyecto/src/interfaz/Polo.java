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
		
	setVisible(true);
	setSize(1500, 1000);
	setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuPrincipal= new JMenu("W");
		menuBar.add(menuPrincipal);
		m1=new JMenuItem("Tienda");
		m2= new JMenuItem("Catálogo");
		m3= new JMenuItem("Sobre nosotros...");
		m4= new JMenuItem("Donde encontrarnos");
		
		menuPrincipal.add(m1);
		menuPrincipal.add(m2);
		menuPrincipal.add(m3);
		menuPrincipal.add(m4);
		
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FOTO");
		lblNewLabel.setBounds(544, 101, 188, 118);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MOTOR");
		lblNewLabel_1.setBounds(54, 687, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setBounds(54, 716, 56, 16);
		getContentPane().add(lblColor);
		
		JLabel lblTapiceria = new JLabel("TAPICERIA");
		lblTapiceria.setBounds(54, 745, 90, 16);
		getContentPane().add(lblTapiceria);
		
		JLabel lblLlantas = new JLabel("LLANTAS");
		lblLlantas.setBounds(54, 774, 56, 16);
		getContentPane().add(lblLlantas);
		
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
		
		JRadioButton rdbtncv_4 = new JRadioButton("500cv");
		rdbtncv_4.setBounds(726, 683, 127, 25);
		getContentPane().add(rdbtncv_4);
		
		
		
		
		
	}		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Polo();

	}
}
