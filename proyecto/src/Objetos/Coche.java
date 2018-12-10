package Objetos;




public class Coche extends Producto{
	
	private String color;
	private int nAsiento;
	private String tapiceria;
	private int puertas;
	private int litroMaletero;
	

	public Coche(String nombre, double precio, int cantidad, String color, int nAsiento, String tapiceria, int puertas,
			int litroMaletero) {
		super(nombre, precio, cantidad);
		this.color = color;
		this.nAsiento = nAsiento;
		this.tapiceria = tapiceria;
		this.puertas = puertas;
		this.litroMaletero = litroMaletero;
	}
	
	

		public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getnAsiento() {
		return nAsiento;
	}



	public void setnAsiento(int nAsiento) {
		this.nAsiento = nAsiento;
	}



	public String getTapiceria() {
		return tapiceria;
	}



	public void setTapiceria(String tapiceria) {
		this.tapiceria = tapiceria;
	}



	public int getPuertas() {
		return puertas;
	}



	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}



	public int getLitroMaletero() {
		return litroMaletero;
	}



	public void setLitroMaletero(int litroMaletero) {
		this.litroMaletero = litroMaletero;
	}


	

	



		@Override
	public String toString() {
		return  color + "," + nAsiento + "," + tapiceria + "," + puertas+ "," + litroMaletero;
	}



		public static void main(String[] args) {
		
			

	}

}
