package interfaz;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PoloDiesel extends JFrame{
	public PoloDiesel() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PoloDiesel.class.getResource("/interfaz/poloDieselPrin.jpg")));
		btnNewButton.setBounds(356, 390, 532, 323);
		getContentPane().add(btnNewButton);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
