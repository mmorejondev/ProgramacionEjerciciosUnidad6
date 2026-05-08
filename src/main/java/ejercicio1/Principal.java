package ejercicio1;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import conectorbd.ConectorBaseDatos;

public class Principal {

	public static void main(String[] args) {

		Connection conn=null;
		ConectorBaseDatos conector = new ConectorBaseDatos();
		conn = conector.obtenerConexion();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca edad mínima: ");
		int edadMinima=teclado.nextInt();
		System.out.println("Introduzca edad máxima: ");
		int edadMaxima=teclado.nextInt();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
			List<Empleado> listaEmpleados = new ArrayList<>();
			System.out.println("Listado de empleados que cumplen requisitos de edad");
			while(rs.next()) {
				if (rs.getInt("edad") >= edadMinima && rs.getInt("edad") <= edadMaxima) {
					Empleado e = new Empleado(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getInt("edad"));
					System.out.println(e);
					listaEmpleados.add(e);
				}
			}
			
			/*Escribimos la lista al archivo JSON de salida*/
			File archivoSalida = new File("personasEntre25y30.json");
			ObjectMapper mapeador = new ObjectMapper();
			mapeador.writeValue(archivoSalida,listaEmpleados);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
