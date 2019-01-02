package interfaz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import bd.BaseDeDatos;
import properties.Datos;

public class inicio {
public static void main(String[] args) {
	//InicioSesion ini=new  InicioSesion();
	//prueba de properties
	try {
		Datos d=new Datos();
		System.out.println(d.getUsuario());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
