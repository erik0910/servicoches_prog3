package Objetos;

public class Pieza extends Producto{

	
	private int peso;
	private int modelo;
	private int tama�o;
	
	
	
	
	
	public Pieza(String nombre, double precio, int cantidad, int peso, int modelo, int tama�o) {
		super(nombre, precio, cantidad);
		this.peso = peso;
		this.modelo = modelo;
		this.tama�o = tama�o;
	}





	public int getPeso() {
		return peso;
	}





	public void setPeso(int peso) {
		this.peso = peso;
	}





	public int getModelo() {
		return modelo;
	}





	public void setModelo(int modelo) {
		this.modelo = modelo;
	}





	public int getTama�o() {
		return tama�o;
	}





	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}





	@Override
	public String toString() {
		return "Pieza [peso=" + peso + ", modelo=" + modelo + ", tama�o=" + tama�o + "]";
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
