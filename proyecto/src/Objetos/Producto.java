package Objetos;

public class Producto {
private String nombre;
private double precio;
private int cantidad;
public Producto(String nombre, double precio, int cantidad) {
	this.nombre = nombre;
	this.precio = precio;
	this.cantidad = cantidad;
	
}
//No quiero que en hash-set se repitan las compras 
 @Override
	public boolean equals(Object obj) {
		if(obj instanceof Producto) {
			Producto comparar=(Producto)obj;
			return comparar.getNombre().equals(this.getNombre());
		}
		return false;
	}
 //todavia no se puede crear un hash code correcto ya que falta la herencia de productos
 @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
 //metodo to string
@Override
public String toString() {
	return "Producto [nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
}
//getters y setters
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

}
