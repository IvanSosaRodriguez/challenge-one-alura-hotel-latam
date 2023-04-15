package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnetion  {
	
	//crea una funcion con la que se conecta a la base de datos
    public Connection abreConnection() throws SQLException {

            return DriverManager.getConnection(
                "jdbc:mysql://localhost/HotelAlura?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "1234");
    }
}