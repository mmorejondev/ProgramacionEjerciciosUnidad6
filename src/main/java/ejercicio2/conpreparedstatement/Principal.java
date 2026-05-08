package ejercicio2.conpreparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import conectorbd.ConectorBaseDatos;

public class Principal {

	public static void main(String[] args) {

		Connection conn=null;
		ConectorBaseDatos conector  = new ConectorBaseDatos();
		conn = conector.obtenerConexion();
		
		/*Pedimos los datos por consola*/
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca dni: ");
		String dni=teclado.nextLine();
		System.out.println("Introduzca nombre: ");
		String nombre=teclado.nextLine();
		System.out.println("Introduzca apellidos: ");
		String apellidos=teclado.nextLine();
		System.out.println("Introduzca edad: ");
		int edad=teclado.nextInt();

		String cadenaInsercion = "INSERT INTO empleados (dni,nombre,apellidos,edad) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(cadenaInsercion);
			pstmt.setString(1,dni);
			pstmt.setString(2,nombre);
			pstmt.setString(3,apellidos);
			pstmt.setInt(4,edad);
			
			int filasAfectadas=pstmt.executeUpdate();
			if (filasAfectadas>0) {
				System.out.println("Datos insertados correctamente.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
