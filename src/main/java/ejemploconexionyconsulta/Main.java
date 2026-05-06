package ejemploconexionyconsulta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		 Connection conn=null;
		 ConectorBaseDatos conector = new ConectorBaseDatos();  
		 conn=conector.obtenerConexion();
		 
		 try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
			while(rs.next()) {
				System.out.print("DNI: " + rs.getString("dni"));
				System.out.print(" - Nombre: " + rs.getString("nombre"));
				System.out.print(" - Apellidos: " + rs.getString("apellidos"));
				System.out.print(" - Edad: " + rs.getInt("edad"));
				System.out.println();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		}

}


