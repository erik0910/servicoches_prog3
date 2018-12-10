package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Objetos.USUARIO;

public class BaseDeDatos {
	public static Logger log;
	public static Connection iniciar() {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection conexion = DriverManager.getConnection("jdbc:sqlite:servichoches.db");
		System.out.println("ha entrado");
		    return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void insertarUsuarios(Statement state,USUARIO u,int i) {
		String sentSQL="";
		
		try {
			sentSQL = "insert into Usuario values('" +i+"'"+
					",'" + u.getNombre()+"',"+ "'"+u.getContra()+"',"+u.getSaldo()+","+i+")";
			int val = state.executeUpdate( sentSQL );
			
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
	//metodo para crear todas las tablas que se usaran en este programa
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table Producto " +
					"( id integer not null primary key ,"
					+ "nombre text ,"
					+ "precio numeric ");
			} catch (Exception e) {
				System.out.println("la tabla  producto ya ha sido creada");
			}
			try {
				statement.executeUpdate("create table Cesta " +
					"( id integer not null primary key ,"
					+ "id_producto integer ,"
					+ "cantidad integer ,"
					+ "costeTotal numeric ,"
					+ " FOREIGN KEY(id_producto) REFERENCES Producto(id))");
				System.out.println("ha sido creada la tabla correctamente");
			} catch (SQLException e) {
				System.out.println("ya ha sido creada la tabla cesta");
			} 
			try {
				statement.executeUpdate("create table Usuario " +
						"( id integer not null primary key AUTOINCREMENT ,"//para que no se repita y se incremente 
						+ "nombre text ,"
						+ "contra text ,"
						+ "saldo numeric ,"
						+ "id_cesta integer ,"
						+ " FOREIGN KEY(id_cesta) REFERENCES Cesta(id) ON DELETE CASCADE ) "//EN EL CASO DE QUE SE BORRE LA CESTA DE
						//PEDIDOS SE ELIMINARA TODA REFERENCIA DE LA TABLA CESTA 
						
						);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("se ha creado la tabla Usuario");
			}
			
			System.out.println("actualizaciÛn creada correctamente");
			return statement;
		} catch (SQLException e) {
	
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<USUARIO> cargaUsuario(Connection con ,Statement st){
		String sentSQL="";
		ArrayList< USUARIO>devolver=new ArrayList<>();
		try {
			sentSQL = "select * from Usuario";
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				USUARIO usua=new USUARIO(rs.getString("nombre"), rs.getString("contra"), 0);
				devolver.add(usua);
			}
			rs.close();
			return devolver;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//para conseguir el  id del usuario
	public static int idUsuario(Connection con ,Statement st,String nombre) {
		String mensaje="select id from Usuario where nombre = '"+ nombre+ "'";
		try {
			ResultSet rs=st.executeQuery(mensaje);
			return rs.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void cerrarBD(Connection con ,Statement st) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		System.out.println("se ha cerrado la base de datos");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	private static String secu(String string) {
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÒ—·ÈÌÛ˙¸¡…Õ”⁄⁄.,:;-_(){}[]-+*=<>'\"ø?°!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
}
