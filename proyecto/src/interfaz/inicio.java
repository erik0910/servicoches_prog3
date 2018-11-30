package interfaz;

import java.sql.Connection;
import java.sql.Statement;

import bd.BaseDeDatos;

public class inicio {
public static void main(String[] args) {
	//InicioSesion ini=new  InicioSesion();
	Connection con=BaseDeDatos.iniciar();
	Statement st=BaseDeDatos.usarCrearTablasBD(con);
	BaseDeDatos.cerrarBD(con, st);
}
}
