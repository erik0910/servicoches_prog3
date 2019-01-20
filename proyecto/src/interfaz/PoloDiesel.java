package interfaz;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PoloDiesel extends JFrame{
	
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem miCata;
	private JMenuItem miLug;
	private JMenuItem miInicio;
	
	
	
	public PoloDiesel() {
		getContentPane().setLayout(null);
		
		barraMenu = new JMenuBar();
		menu = new JMenu("SC");
		barraMenu.add(menu);
		miCata = new JMenuItem("Catálogo");
		miLug= new JMenuItem("Donde encontrarnos");
		miInicio = new JMenuItem("Inicio");
		
		menu.add(miCata);
		menu.add(miInicio);
		menu.add(miLug);
	
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PoloDiesel.class.getResource("/interfaz/poloDieselPrin.jpg")));
		btnNewButton.setBounds(356, 390, 532, 323);
		getContentPane().add(btnNewButton);
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
