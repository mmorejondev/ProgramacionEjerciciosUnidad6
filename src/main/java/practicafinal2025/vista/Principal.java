package practicafinal2025.vista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import practicafinal2025.ConectorBaseDatos;
import practicafinal2025.modelo.Videojuego;

public class Principal {

	public static void main(String[] args) {

		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca precio mínimo: ");
		Integer precioMin = teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("Introduzca precio máximo: ");
		Integer precioMax = teclado.nextInt();
		teclado.nextLine();
		
		String consulta = "SELECT * FROM videojuegos WHERE precio BETWEEN " + precioMin + " AND " + precioMax;
		
		 try {
			Statement orden1 = conn.createStatement();
			List<Videojuego> lista = new ArrayList<>();
			ResultSet vFiltrados = orden1.executeQuery(consulta);
			while(vFiltrados.next()) {
				Videojuego v = new Videojuego(vFiltrados.getString(1),vFiltrados.getString(2),vFiltrados.getString(3),vFiltrados.getDouble(4));
				lista.add(v);
			}
			Iterator<Videojuego> it = lista.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			lista.clear();
			System.out.println("Ingrese la plataforma para listar sus videojuegos: ");
			String plataforma = teclado.nextLine();
			
			String consultaPlataforma = "SELECT * FROM videojuegos WHERE plataforma='"+ plataforma + "'";
			Statement orden2 = conn.createStatement();
			ResultSet vPlataforma = orden2.executeQuery(consultaPlataforma);
			while(vPlataforma.next()) {
				Videojuego v = new Videojuego(vPlataforma.getString(1),vPlataforma.getString(2),vPlataforma.getString(3),vPlataforma.getDouble(4));
				lista.add(v);
			}
			
			Iterator<Videojuego> it2 = lista.iterator();
			while(it2.hasNext()) {
				System.out.println(it2.next());
			}
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
