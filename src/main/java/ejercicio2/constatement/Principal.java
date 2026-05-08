package ejercicio2.constatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import conectorbd.ConectorBaseDatos;

public class Principal {

	public static void main(String[] args) {

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

		String cadenaInsercion = "INSERT INTO empleados (dni,nombre,apellidos,edad) VALUES (" + "'" + dni + "'" + "," + "'" + nombre + "'" + "," + "'" + apellidos + "'" + "," + edad + ")";
		//System.out.println(cadenaInsercion);
		Connection conn=null;
		ConectorBaseDatos conector  = new ConectorBaseDatos();
		conn = conector.obtenerConexion();
		try {
			Statement stmt = conn.createStatement();
			int filasAfectadas=stmt.executeUpdate(cadenaInsercion);
			if (filasAfectadas>0) {
				System.out.println("Datos insertados correctamente.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
