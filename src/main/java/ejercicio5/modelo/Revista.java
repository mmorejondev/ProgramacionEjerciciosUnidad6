package ejercicio5.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Revista extends Item{

	String periodicidad;
	String tema;
	
	public Revista(int id, String titulo, int anyoPublicacion, String periodicidad, String tema) {
		super(id, titulo, anyoPublicacion);
		this.periodicidad = periodicidad;
		this.tema = tema;
	}
	

	@Override
	public void guardarEnBaseDeDatos() {
		ConectorBaseDatos conector= new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
				
		String insert = "INSERT INTO revistas VALUES (?,?,?,?,?)";
		PreparedStatement pstm;
		try {
			pstm = conn.prepareStatement(insert);
			pstm.setInt(1,this.id);
			pstm.setString(2,this.titulo);
			pstm.setInt(3, this.anyoPublicacion);
			pstm.setString(4,this.periodicidad);
			pstm.setString(5, this.tema);
			int filasAfectadas=pstm.executeUpdate();
			if (filasAfectadas>0) {
				System.out.println("Revista insertada correctamente");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
			
	} 
		
	
	
	public static Revista leerRevistaBD(int id) {
		
		ConectorBaseDatos conector= new ConectorBaseDatos();
		Connection conn = conector.obtenerConexion();
		String consulta = "SELECT * FROM revistas WHERE id=" + id;
		Statement stm;
		Revista l=null;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(consulta);
			if (rs.next()) {
				l = new Revista(rs.getInt("id"),rs.getString("titulo"),rs.getInt("añoPublicacion"),rs.getString("periodicidad"),rs.getString("tema"));
			}
			
		}catch(SQLException e) {
			
		}
		return l;
	}
	
	

	

}
