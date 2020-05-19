import java.sql.*;

public class dbhotel {
	
Connection con;

public dbhotel() {
	
}

public Connection db_connect() throws SQLException, ClassNotFoundException{ 
	
	 Class.forName("com.mysql.jdbc.Driver");
	 
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb?autoReconnect=true&useSSL=false","root","");
	 
	 return con;
}
public void close_connect() throws SQLException{
	con.close();
	//c'est une methode qui ne retourne rien


}
}