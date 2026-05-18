package practicafinal2025MVC.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import practicafinal2025MVC.modelo.ConectorBaseDatos;
import practicafinal2025MVC.modelo.Videojuego;

public class Modelo {

	public List<Videojuego> devolverVideojuegosPorPrecio (Double min, Double max){
		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		List<Videojuego> lista = new ArrayList<>();
		String consulta = "SELECT * FROM videojuegos WHERE precio BETWEEN " + min + " AND " + max;

		 try {
			Statement orden1 = conn.createStatement();
			ResultSet vFiltrados = orden1.executeQuery(consulta);
			/*Creamos una lista con objetos Videojuego contenidos en el ResultSet */
			/*Crear la lista no es necesario, lo hacemos por repasar*/
			while(vFiltrados.next()) {
				Videojuego v = new Videojuego(vFiltrados.getString("id"),vFiltrados.getString("titulo"),vFiltrados.getString("plataforma"),vFiltrados.getDouble("precio"));
				lista.add(v);
			}
			 conn.close();  	

		 }catch (SQLException e) {
				e.printStackTrace();
		}
		 
		 return lista;
    }
	
	
	
	public List<Videojuego> devolverVideojuegosPorPlataforma (String plataforma){
		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		
	
		List<Videojuego> lista = new ArrayList<>();
	
		String consultaPlataforma = "SELECT * FROM videojuegos WHERE plataforma='"+ plataforma + "'";
		Statement orden2;
		try {
			orden2 = conn.createStatement();
			ResultSet vPlataforma = orden2.executeQuery(consultaPlataforma);
			while(vPlataforma.next()) {
				Videojuego v = new Videojuego(vPlataforma.getString(1),vPlataforma.getString(2),vPlataforma.getString(3),vPlataforma.getDouble(4));
				lista.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}



	public void guardarVideoJuegoNuevo(Videojuego nuevo) {
		
		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		String cadenaInsercion = "INSERT INTO videojuegos VALUES (?,?,?,?)";
		PreparedStatement orden3;
		try {
			orden3 = conn.prepareStatement(cadenaInsercion);
			orden3.setString(1, nuevo.getId());
			orden3.setString(2, nuevo.getTitulo());
			orden3.setString(3, nuevo.getPlataforma());
			orden3.setDouble(4, nuevo.getPrecio());
			
			int filasAfectadas=orden3.executeUpdate();
			if (filasAfectadas>0)
				System.out.println("Inserción correcta.");
			else {
				System.out.println("Fallo en la inserción");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	public void borrarVideojuegoPorId(String idABorrar) {
		
		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		String cadenaBorrado = "DELETE FROM videojuegos WHERE id = ?";
		PreparedStatement orden4;
		try {
			orden4 = conn.prepareStatement(cadenaBorrado);
			orden4.setString(1, idABorrar);
			int filasAfectadas=orden4.executeUpdate();
			if (filasAfectadas>0)
				System.out.println("Borrado correcto.");
			else {
				System.out.println("Fallo en el borrado");
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modificarPrecioVideojuegoPorId(String id, double precio){
		
		ConectorBaseDatos conector = new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		
		try {
		String cadenaModificacion = "UPDATE videojuegos SET precio=? WHERE id=?";
		PreparedStatement orden5 = conn.prepareStatement(cadenaModificacion);
		orden5.setDouble(1,precio);
		orden5.setString(2, id);
		
		int filasAfectadas=orden5.executeUpdate();
		if (filasAfectadas>0)
			System.out.println("Modificación correcta.");
		else {
			System.out.println("Fallo en la modificación.");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
