package practicafinal2025.vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			/*Creamos una lista con objetos Videojuego contenidos en el ResultSet */
			/*Crear la lista no es necesario, lo hacemos por repasar*/
			while(vFiltrados.next()) {
				Videojuego v = new Videojuego(vFiltrados.getString("id"),vFiltrados.getString("titulo"),vFiltrados.getString("plataforma"),vFiltrados.getDouble("precio"));
				lista.add(v);
			}
			/*Recorremos la lista usando un iterador (por repasar)*/			
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
			
			System.out.println("INSERTAMOS UN NUEVO VIDEOJUEGO");
			System.out.println("Inserte nuevo ID: ");
			String nuevoId = teclado.nextLine();
			System.out.println("Inserte titulo: ");
			String nuevoTitulo = teclado.nextLine();
			System.out.println("Inserte plataforma: ");
			String nuevaPlat = teclado.nextLine();
			System.out.println("Inserte precio: ");
			Double nuevoPrecio = teclado.nextDouble();
			teclado.nextLine();
			
			String cadenaInsercion = "INSERT INTO videojuegos VALUES (?,?,?,?)";
			PreparedStatement orden3 = conn.prepareStatement(cadenaInsercion);
			orden3.setString(1, nuevoId);
			orden3.setString(2, nuevoTitulo);
			orden3.setString(3, nuevaPlat);
			orden3.setDouble(4, nuevoPrecio);
			
			int filasAfectadas=orden3.executeUpdate();
			if (filasAfectadas>0)
				System.out.println("Inserción correcta.");
			else {
				System.out.println("Fallo en la inserción");
			}
			
			System.out.println("BORRAMOS UN VIDEOJUEGO");
			System.out.println("Inserte ID a eliminar: ");
			String idABorrar = teclado.nextLine();
			String cadenaBorrado = "DELETE FROM videojuegos WHERE id = ?";
			PreparedStatement orden4 = conn.prepareStatement(cadenaBorrado);
			orden4.setString(1, idABorrar);
			filasAfectadas=orden4.executeUpdate();
			if (filasAfectadas>0)
				System.out.println("Borrado correcto.");
			else {
				System.out.println("Fallo en el borrado");
			}
			
			System.out.println("MODIFICAMOS PRECIO DE UN VIDEOJUEGO");
			System.out.println("Inserte ID a modificar: ");
			String idAModificar = teclado.nextLine();
			System.out.println("Inserte nuevo precio: ");
			Double precioModificado = teclado.nextDouble();
			teclado.nextLine();
			
			String cadenaModificacion = "UPDATE videojuegos SET precio=? WHERE id=?";
			PreparedStatement orden5 = conn.prepareStatement(cadenaModificacion);
			orden5.setDouble(1,precioModificado);
			orden5.setString(2, idAModificar);
			
			filasAfectadas=orden5.executeUpdate();
			if (filasAfectadas>0)
				System.out.println("Modificación correcta.");
			else {
				System.out.println("Fallo en la modificación.");
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
