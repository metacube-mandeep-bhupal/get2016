package model;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
*Following class is a singleton class and provides a connection to the database whenever any operation is performed on database.
*/
public class ConnectionFactory {

	
	private Connection connection;
	private static ConnectionFactory connectionFactory; 
	private ConnectionFactory(){
		connection = null;
		connectionFactory = null;
		
	}
	
	/**
	*Following function helps in getting the connection so that we can interact with the database.
	*Returns the Connection to where it is required.
	*/
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
	 *Following function helps in closing the connection  which was opened on request by the entity of interest.
	 * @return true/false whether the connection has been closed successfully or not.
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
	 * Following function is used to open or initialize connection.
	 * @return true if already open else return false.
	 * @throws SQLException // if sql run time error come
	 * @throws ClassNotFoundException //if class not found
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

	public static ConnectionFactory getInstance(){
		if(connectionFactory == null){
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
