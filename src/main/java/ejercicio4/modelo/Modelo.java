package ejercicio4.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conectorbd.ConectorBaseDatos;

public class Modelo {

	ConectorBaseDatos conector = new ConectorBaseDatos();
	Connection conn = conector.obtenerConexion();
	
	/**
	 * Metodo que devuelve una lista de empleados desde el almacenamiento.
	 * */
	public List<Empleado> leerDatos(){
		List<Empleado> listaEmpleados = new ArrayList<>();
		String consulta = "SELECT * FROM empleados";
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			while(rs.next()) {
				Empleado e = new Empleado();
				e.setDni(rs.getString("dni"));
				e.setNombre(rs.getString("nombre"));
				e.setApellidos(rs.getString("apellidos"));
				e.setEdad(rs.getInt("edad"));
				listaEmpleados.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaEmpleados;
	}
}
