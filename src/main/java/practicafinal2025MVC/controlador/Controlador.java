package practicafinal2025MVC.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import practicafinal2025MVC.modelo.*;

public class Controlador {

	public List<Videojuego> filtrarPorPrecio() {
		System.out.println("FILTRADO POR PRECIO");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca precio mínimo: ");
		Double precioMin = teclado.nextDouble();
		teclado.nextLine();
		
		System.out.println("Introduzca precio máximo: ");
		Double precioMax = teclado.nextDouble();
		teclado.nextLine();
		Modelo modelo = new Modelo();
		
		List<Videojuego> resultado = modelo.devolverVideojuegosPorPrecio(precioMin, precioMax);
		return resultado;
	}

	public List<Videojuego> filtrarPorPlataforma() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca plataforma: ");
		String plataforma = teclado.nextLine();
		Modelo modelo = new Modelo();
		List<Videojuego> l = new ArrayList<>();
		l= modelo.devolverVideojuegosPorPlataforma(plataforma);
		return l;
		
	}

	public void insertarNuevoVideojuego() {
		Scanner teclado = new Scanner(System.in);
		
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
		
		Videojuego nuevo = new Videojuego(nuevoId,nuevoTitulo,nuevaPlat,nuevoPrecio);
		Modelo modelo = new Modelo();
		modelo.guardarVideoJuegoNuevo(nuevo);
		
	}

	public void borrarVideojuego() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Inserte ID a eliminar: ");
		String idABorrar = teclado.nextLine();
		Modelo modelo = new Modelo();
		modelo.borrarVideojuegoPorId(idABorrar);
		
		
		
		
		
		
	}

	public void modificarPrecioVideojuegoPorId() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("MODIFICAMOS PRECIO DE UN VIDEOJUEGO");
		
		System.out.println("Inserte ID a modificar: ");
		String idAModificar = teclado.nextLine();
		System.out.println("Inserte nuevo precio: ");
		Double precioModificado = teclado.nextDouble();
		teclado.nextLine();
		
		Modelo modelo = new Modelo();
		modelo.modificarPrecioVideojuegoPorId(idAModificar,precioModificado);
		
				
	}
}

