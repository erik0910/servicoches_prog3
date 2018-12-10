package efectoLogotipo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class coche extends JFrame {
	//se ha creado esta clase para probar y mejorra el logotipo del proyecto
	//todavia no es un efecto final y es por eso que no se ha implementado en la aplicacion
	Graphics g;
	BufferedImage imagen=null;
	String nombre="coche";
	int i=1;
	int count=0;
	public coche() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblServicoches = new JLabel("SERVI-COCHES");
		lblServicoches.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 86));
		lblServicoches.setBounds(31, 764, 900, 200);
		getContentPane().add(lblServicoches);
		pack();
		setLocationRelativeTo(null);
		setSize(new Dimension(1100, 1100));
		setPreferredSize(getSize());
		setVisible(true);
		paint(g);
	}
	public static void main(String[] args) {
		new coche();
	}
	@Override
	public void paint(Graphics g1) {
		try {
			imagen=ImageIO.read(getClass().getResource("/imagenes/"+nombre+i+".jpg"));
			g1.drawImage(imagen, 150, 60, 900,200, null);
			//el objetivo de la funcion count es unicamente la de repetir imagenes para hacer la transiciones mas
			//lentas
			if(i<10 && count==9) {i++;count=0; }
			else if(count<9){count++;}
			else {/*dispose();*/}//para que el hilo no sigua corriendo y gastando recursos
			repaint();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
}
