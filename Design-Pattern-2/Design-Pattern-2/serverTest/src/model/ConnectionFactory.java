package model;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	
	private Connection connection;
	private static ConnectionFactory connectionFactory; 
	private ConnectionFactory(){
		connection = null;
		connectionFactory = null;
		
	}
	public Connection getConnection() throws SQLException, ClassNotFoundException, IOException{
		if(this.connection == null || this.connection.isClosed() ){
			try{
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
				Properties properties = new Properties();
				properties.load(inputStream);
				String mysqlURL = properties.getProperty("DB_URL");
				String userId = properties.getProperty("DB_USERNAME");
				String password = properties.getProperty("DB_PASSWORD");
				String db_class = properties.getProperty("DB_DRIVER_CLASS");
				System.out.println(mysqlURL);
				System.out.println(userId);
				System.out.println(password);
				System.out.println(db_class);
				Class.forName(db_class);
				this.connection = DriverManager.getConnection(mysqlURL, userId, password);
			}
			catch(SQLException sqlEx){
				sqlEx.printStackTrace();
			}
		}
		return connection;
	}
	/**
	 * 
	 * @return if connection close successfully then return true else false
	 */
	public boolean closeConnection() throws SQLException{
		if(this.connection.isClosed() == false ){
			this.connection.close();
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * use to open or initialize connection 
	 * @return if already open then return false else return true 
	 * @throws SQLException // if sql run time error come
	 * @throws ClassNotFoundException //if class not found
	 * @throws IOException 
	 */
	public boolean openConnection() throws SQLException, ClassNotFoundException, IOException{
		if(this.connection == null || this.connection.isClosed()){
			this.connection = getConnection();
			return true;
		}
		else{
			return true;
		}
	}
	// if dao manager is static then any body can access it.
	//this should be not static
	public static ConnectionFactory getInstance(){
		if(connectionFactory == null){
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
