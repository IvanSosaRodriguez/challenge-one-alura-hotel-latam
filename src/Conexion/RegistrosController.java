package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrosController {
	
	public RegistrosController() {
		
	}

    
    public List<Map<String, String>> CargarHuespedes() throws SQLException {
        //abre coneccion a la base de datos
    	Connection con = new FactoryConnetion().abreConnection();
    	//crea un metodo para mandar la solicitud en lenguage sql
    	Statement statement = con.createStatement();
        //ejecuta el codigo creado
        statement.execute("SELECT * FROM huespedes");
        //aqui se guarda el resultado consultado
        ResultSet resultSet = statement.getResultSet();
        
        List<Map<String, String>> resultado = new ArrayList<>();
          //ciclo para leer todas las filas obtenidas
        while(resultSet.next()) {
        	   //se crea un map donde se guardaran los datos
        	Map<String,String> fila = new HashMap<>();
        	fila.put("ID",String.valueOf(resultSet.getInt("ID_huespedes")));
        	fila.put("NOMBRE",resultSet.getString("Nombre"));
        	fila.put("APELLIDO",resultSet.getString("Apellido"));
        	fila.put("FECHADENACIMIENTO", String.valueOf(resultSet.getDate("FechaDeNacimiento")));
        	fila.put("NACIONALIDAD",resultSet.getString("nacionalidad"));
        	fila.put("TELEFONO",resultSet.getString("telefono"));
        	fila.put("ID_RESERVA",String.valueOf(resultSet.getInt("ID_reserva")));
        	   //aqui se añade a list
        	resultado.add(fila);
        
        }
           //devuelve una lista de maps con los datos de la bd
        return resultado;
    }
    
    public List<Map<String, String>> CargarReservas() throws SQLException {
    
    Connection con = new FactoryConnetion().abreConnection();
    
    Statement statement = con.createStatement();
    
        statement.execute("SELECT * FROM reservas");

        ResultSet resultSet = statement.getResultSet();
        
        List<Map<String, String>> resultado = new ArrayList<>();
        
        while(resultSet.next()) {
        
        Map<String,String> fila = new HashMap<>();
        fila.put("ID",String.valueOf(resultSet.getInt("ID_Reserva")));
        fila.put("FECHAENTRADA",String.valueOf(resultSet.getDate("FechaEntrada")));
        fila.put("FECHASALIDA", String.valueOf(resultSet.getDate("FechaSalida")));
        fila.put("VALOR",String.valueOf(resultSet.getFloat("Valor")));
        fila.put("FORMADEPAGO",resultSet.getString("FormaPago"));
        
        resultado.add(fila);

        }

        return resultado;
    }
}
