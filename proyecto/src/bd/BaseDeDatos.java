package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Objetos.USUARIO;


public class BaseDeDatos {
	private static Exception lastError = null; 
	public static Logger log;
	//aÒadir situacion reciente de la base de datos
	public static void setLogger( Logger logger ) {
		BaseDeDatos.log = logger;
	}
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (log==null) {  // Logger por defecto local:
			log = Logger.getLogger( BaseDeDatos.class.getName() );  // Nombre del logger  de la clase
			log.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				log.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				log.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			log.log( level, msg );
		else
			log.log( level, msg, excepcion );
	}
	public static Connection iniciar() {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection conexion = DriverManager.getConnection("jdbc:sqlite:servichoches.db");
		System.out.println("ha entrado");
		    return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	//para ontener la ultikma excepion
	public static Exception getLastError() {
		return lastError;
	}
	//los correpsondientes insert
	public static void insertarUsuarios(Statement state,USUARIO u,int i) {
		String sentSQL="";
		
		try {
			sentSQL = "insert into Usuario values('" +i+"'"+
					",'" + secu(u.getNombre())+"',"+ "'"+secu(u.getContra())+"',"+ u.getSaldo()+","+i+")";
			int val = state.executeUpdate( sentSQL );
			
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en al insertar datos en la base de datos", e );
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
			lastError = e;
			log( Level.SEVERE, "Error al conectar en la base de  datos", e );
			e.printStackTrace();
			return null;
		}
	}
	//metodo para crear todas las tablas que se usaran en este programa
	//creadas manualmente
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
				lastError = e;
				log( Level.SEVERE, "ya ha sido creada la tabla producto", e );
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
				lastError = e;
				log( Level.SEVERE, "ya ha sido creada la tabla cesta", e );
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
				lastError = e;
				log( Level.SEVERE, "ya ha sido creada la tabla usuario", e );
			}
			//como recurso primitivo para saber que estoy conectado y que ha salido todo bien
			System.out.println("actualizaciÛn creada correctamente");
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "error en la creacion de las tablas", e );
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
			lastError = e;
			log( Level.SEVERE, "erro en la lectura de la base de datos", e );
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
			lastError = e;
			log( Level.SEVERE, "error al cerrar la base de datos", e );
			e.printStackTrace();
		}
	}
	//objetivo de este mÈtodo es concatenar los caracteres que seran premitidos y los que no 
	//se encuentren en los permitidos simplemente no se guaradran en la base de datos 
	private static String secu(String string) {
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÒ—·ÈÌÛ˙¸¡…Õ”⁄⁄.,:;-_(){}[]-+*=<>'\"ø?°!&%$@#/\\0123456789".indexOf(c)>=0)
				ret.append(c);//para concatenar la palabras que si queremos que se guarde en la base de datos
		}
		return ret.toString();
	}
}
