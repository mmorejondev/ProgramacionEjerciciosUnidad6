package ejercicio5.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Libro extends Item implements Prestable{

	String autor;
	String editorial;
	Boolean prestado;
	
	public Boolean getPrestado() {
		return prestado;
	}

	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
	}

	public Libro(int id, String titulo, int anyoPublicacion, String autor, String editorial, Boolean prestado) {
		super(id, titulo, anyoPublicacion);//constructor de item
		this.autor = autor;
		this.editorial = editorial;
		this.prestado=prestado;
	}

	@Override
	public void guardarEnBaseDeDatos() {
		ConectorBaseDatos conector= new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		String consulta = "SELECT * FROM libros WHERE id=" + this.id;
		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {//el libro existe, tenemos que hacer un update
				String update = "UPDATE libros SET prestado=? WHERE id=?";
				PreparedStatement pstm = conn.prepareStatement(update);
				pstm.setBoolean(1,this.prestado);
				pstm.setInt(2,this.id);
				int filasAfectadas=pstm.executeUpdate();
				if (filasAfectadas>0) {
					System.out.println("Libro actualizado correctamente");
				}
				
			}else {//el libro no existe en la bbdd, tenemos que hacer un insert
			
				String insert = "INSERT INTO libros VALUES (?,?,?,?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(insert);
				pstm.setInt(1,this.id);
				pstm.setString(2,this.titulo);
				pstm.setInt(3, this.anyoPublicacion);
				pstm.setString(4,this.autor);
				pstm.setString(5, this.editorial);
				pstm.setBoolean(6, this.prestado);
				
				
				int filasAfectadas=pstm.executeUpdate();
				if (filasAfectadas>0) {
					System.out.println("Libro insertado correctamente");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Libro leerLibroBD(int id) {
		
		ConectorBaseDatos conector= new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		String consulta = "SELECT * FROM libros WHERE id=" + id;
		Statement stm;
		Libro l=null;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				l = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getInt("añoPublicacion"),rs.getString("autor"),rs.getString("editorial"),rs.getBoolean("prestado"));
			}
			
		}catch(SQLException e) {
			
		}
		return l;
	}

	@Override
	public void prestar() {
		if (!this.getPrestado())
			this.setPrestado(true);
	}

	@Override
	public void devolver() {

		if (this.getPrestado())
			this.setPrestado(false);
	}
	
	

	

}
