package Objetos;

import java.util.HashSet;

public class USUARIO {
	private String nombre;
	private String contra;
	private double saldo;
	private HashSet<Producto>compra;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContra() {
		return contra;
	}
	//TODAVIA HAY QUE PENSAR COMO INCLUIR ESTE METODO PERO EL OBJETIVO ES SIMULAR 
	//UNA TARJETA DE CREDITO
	public void meterSALDO(String contra) {
		this.contra = contra;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public HashSet<Producto> getCompra() {
		return compra;
	}
	public void setCompra(HashSet<Producto> compra) {
		this.compra = compra;
	}
	public USUARIO(String nombre, String contra, double saldo) {
		
		this.nombre = nombre;
		this.contra = contra;
		this.saldo = 0;
		this.compra=new  HashSet<>();
		
	}
	@Override
	public String toString() {
		return nombre +";"+contra+";"+saldo;
	}
	
}
