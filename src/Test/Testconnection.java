package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testconnection {

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/HotelAlura?useTimeZone=true&serverTimeZone=UTC",
                    "root",
                    "1234")) {
                        System.out.println("conexion realizada");

        } catch (SQLException e) {

            e.printStackTrace();
        }      
        
        
        
    }
    
}
