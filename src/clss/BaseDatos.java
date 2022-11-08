package clss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase encargada de gestionar la base de datos
 *
 */
public class BaseDatos {
		private static Logger logger= Logger.getLogger("BaseDatos");
		public static class SQL{
		private static Connection connection;
		/**
		 * Comienza la conexión a la base de datos
		 * @param name nombre de la base de datos. Corresponde al nombre del archivo
		 * @return True si ha funcionado
		 */
		public static boolean connect(String name) {
			try {
				logger.log(Level.INFO, "Trying connection to: "+ name+".db");
				connection = DriverManager.getConnection("jdbc:sqlite:"+name+".db");
				return true;
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "Error connecting to database: "+e.getMessage());
				e.printStackTrace();
				return false;
			}
		}
		/**
		 * Devuelve un Set de la tabla elegida.
		 * @param table tabla de la que coger los valores
		 * @param columns columnas a coger separadas por coma o * para coger todas
		 * @param conditions condiciones de la petición
		 * @return ResultSet de lo obtenido
		 */
		public static ResultSet get(String table, String columns, String conditions) {
			return rawQuery("select "+columns+" from "+ table + (conditions==""?"": " WHERE "+conditions), true);
		}
		/**
		 * Devuelve un Set de la tabla elegida.
		 * @param table tabla de la que coger los valores
		 * @param columns columnas a coger separadas por coma o * para coger todas
		 * @return ResultSet de lo obtenido
		 */
		public static ResultSet get(String table, String columns) {
			return rawQuery("select "+columns+" from "+ table, true);
		}
		/**
		 * Devuelve si un valor existe en la base de datos
		 * @param table Tabla en la que buscar
		 * @param column Columna de la tabla
		 * @param value Valor a buscar
		 * @return true si existe. False si no existe o da error
		 */
		public static boolean existsValue(String table, String column, String value) {
			try {
				return rawQuery("SELECT COUNT("+column+ ") FROM "+table+" WHERE "+column+" = "+value, false).getInt(1)>0;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		/**
		 * Manda una petición a la base de datos
		 * @param query SELECT a introducir
		 * @return ResultSet de la petición
		 */
		
		public static ResultSet rawQuery(String query, boolean track) {
			try {
				if(track)logger.log(Level.INFO, "Trying to query: "+query);
				return connection.createStatement().executeQuery(query);
			} catch (SQLException e) {
				logger.log(Level.SEVERE, "Error during query to database: "+e.getMessage());
				return null;
			}
		}
		
		public static void crearBD(String nombre) {
			Statement statement;
			try {
				statement = connection.createStatement();
				String sent = "DROP TABLE IF EXISTS enemigos;";
				statement.executeUpdate(sent);
				sent="CREATE TABLE User (email	varchar(100) PRIMARY KEY ,nombre varchar(100), FNacimiento int,peso	int,altura int,FcardiacaMaxima int,fCardiacaReposo int,provedor INTEGER,estado int);";
				statement.executeUpdate(sent);
				//sent="CREATE TABLE User (email	varchar(100) PRIMARY KEY ,nombre varchar(100), FNacimiento int,peso	int,altura int,FcardiacaMaxima int,fCardiacaReposo int,provedor INTEGER,estado int);"
				statement.executeUpdate(sent);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		boolean conectado = BaseDatos.SQL.connect("BaseDatos");
		if(conectado == false) {
			
		}
		
		ResultSet set = BaseDatos.SQL.get("Cuenta", "*");
		while(set.next()) {
			System.out.println("Usuario: " + set.getString(1) + " Contraseña: " + set.getString(2) + " Tipo Cuenta: " + TipoProvedor.saberTipo(set.getInt(3)).getNombre());
			
		}
	}
}