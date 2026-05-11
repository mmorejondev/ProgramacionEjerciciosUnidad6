package ejercicio4.vista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conectorbd.ConectorBaseDatos;
import ejercicio4.controlador.Controlador;
import ejercicio4.modelo.Empleado;

public class Principal {

	public static void main(String[] args) {
		
		/*Conectar con la base de datos*/
		
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		Controlador control = new Controlador();
		listaEmpleados = control.leerDatos();
		
		/*Hemos terminado de leer de la base de datos y hemos construido
		la lista de Empleado*/
		
		System.out.print("La edad media de los empleados es: ");
		System.out.println(control.calcularEdadMedia(listaEmpleados));
		
		System.out.print("El empleado más joven es: ");
		System.out.println(control.encontrarMasJoven(listaEmpleados));
			
			
		
		
		
		
		
	}

}
