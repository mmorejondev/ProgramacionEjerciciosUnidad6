package ejercicio3;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import conectorbd.ConectorBaseDatos;

public class Principal {

	public static void main(String[] args) {

		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
				
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduzca DNI del empleado para actualizar su edad: ");
		String dniSolicitado = teclado.nextLine();
		
		System.out.println("Introduzca la nueva edad: ");
		int nuevaEdad = teclado.nextInt();
		teclado.nextLine();

		String sentenciaModificacion = "UPDATE empleados SET edad=? WHERE dni=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sentenciaModificacion);
			ps.setInt(1,nuevaEdad);
			ps.setString(2,dniSolicitado);
			int filasAfectadas = ps.executeUpdate();
			
			if (filasAfectadas>0)
				System.out.println("Datos modificados correctamente.");
			else
				System.out.println("No se han modificado los datos.");
			
			String consulta = "SELECT * FROM empleados WHERE dni=" + "'" + dniSolicitado + "'" ;
			Statement st1 = conn.createStatement();
			ResultSet rs = st1.executeQuery(consulta);
			
			
			Empleado e =null;
			while(rs.next()) {
				e=new Empleado(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getInt("edad"));
			}
			ObjectMapper mapeador = new ObjectMapper();
			File archivoSalida1 = new File("usuario_modificado.json");
			mapeador.writeValue(archivoSalida1,e);
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamWriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DatabindException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Introduzca DNI del empleado que desea eliminar: ");
		dniSolicitado = teclado.nextLine();
		
		String sentenciaBorrado = "DELETE FROM empleados WHERE dni=?";
		try {
			PreparedStatement ps1 = conn.prepareStatement(sentenciaBorrado);
			ps1.setString(1,dniSolicitado);
			
			
			/*Recuperamos los datos de la persona que vamos a borrar
			 * para construir el JSON de salida*/
			
			String consulta2 = "SELECT * FROM empleados WHERE dni=" + "'" + dniSolicitado + "'" ;
			Statement st1 = conn.createStatement();
			ResultSet rs = st1.executeQuery(consulta2);
						
			Empleado e =null;
			while(rs.next()) {
				e=new Empleado(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellidos"),rs.getInt("edad"));
			}
			ObjectMapper mapeador = new ObjectMapper();
			File archivoSalida2 = new File("usuario_borrado.json");
			mapeador.writeValue(archivoSalida2,e);
			
			
			
			/*Ejecutamos la sentencia de borrado*/			
			ps1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamWriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DatabindException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
