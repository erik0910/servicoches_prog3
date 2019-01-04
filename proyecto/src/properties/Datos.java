package properties;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {
	//logger especifico de esta clase 
		public static final Logger log=Logger.getLogger(Datos.class.getName());
		  Properties properties = null;
		  //Los datos que van a ser importantes en nuestro fichero tipo properties
		    //nombre de la file 
		    public final static String CONFIG_FILE_NAME = "/properties/datos.properties";
		    //usuario almacenado en el fichero
		    public final static String DATABASE_USER = "dataBaseUser";
		    //contraseña almacenada ne la base de datos
		    public final static String DATABASE_PSWD = "dataBasePassword";
		    //inicia la conexion con nuestro fichero properties
		    public Datos()throws IOException {
		        this.properties = new Properties();
				InputStream is = null;
				 URL url= getClass().getResource(CONFIG_FILE_NAME);
					try {
						
						is = url.openStream();
								
							properties.load(is);
									log.info("conectado satisfactoriamente con nuestro fichero");
					} catch(IOException e) {
							String mensaje="No se ha podido conectar  con el fichero properties";
								log.log(Level.SEVERE, mensaje, e);
					}
		    }
		    //metodo para conseguir el ultimo usuario creado
		    public String getUsuario() {
		    	return properties.getProperty(DATABASE_USER);
		    }
		    //metodo par conseguir contraseña no se usara normalmente pero se guardara 
		    public String getContra() {
		    	return properties.getProperty(DATABASE_PSWD);
		    }
		
}
