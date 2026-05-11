package ejercicio5.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectorBaseDatos{
/*Declaramos tres constantes con la URL de la conexión, el usuario y la contraseña*/
	private static final String URL = "jdbc:mysql://localhost:3306/bibliotecaalixar";
    private static final String USER = "root";
    private static final String PASSWORD = "";


/*Intentamos establecer una conexión, que en Java viene representada en la clase Connection, mediante el método getConnection de la clase DriverManager. Hay que tener en cuenta la SQLException que puede lanzar el método.*/
    
public Connection obtenerConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }


}