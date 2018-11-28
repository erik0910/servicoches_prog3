package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Objetos.USUARIO;

public class BaseDeDatos {
	public static Logger log;
	static int i=0;
	public static Connection iniciar() {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection conexion = DriverManager.getConnection("jdbc:sqlite:proyecto.db");
		System.out.println("ha entrado");
		    return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void insertarUsuarios(Statement state,USUARIO u) {
		String sentSQL="";
		try {
			sentSQL = "insert into Usuario values('" +i+"'"+
					",'" + u.getNombre()+"',"+ "'"+u.getContra()+"',"+u.getSaldo()+")";
			int val = state.executeUpdate( sentSQL );
			i++;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	//sattement para uso de todas las consultas e inclusive
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // 30 msg
			return statement;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public static void cerrarBD(Connection con ,Statement st) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		System.out.println("pablo es retrasado");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
