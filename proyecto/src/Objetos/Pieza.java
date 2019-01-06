package Objetos;

public class Pieza extends Producto{

	
	private int peso;
	private int modelo;
	private int tamaño;
	
	
	
	
	
	public Pieza(String nombre, double precio, int cantidad, int peso, int modelo, int tamaño) {
		super(nombre, precio, cantidad);
		this.peso = peso;
		this.modelo = modelo;
		this.tamaño = tamaño;
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





	public int getTamaño() {
		return tamaño;
	}





	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}





	@Override
	public String toString() {
		return "Pieza [peso=" + peso + ", modelo=" + modelo + ", tamaño=" + tamaño + "]";
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
