package ejercicio5.controlador;
import java.util.Scanner;

import ejercicio5.modelo.*;

public class Controlador {

	public void agregarLibro(Scanner teclado) {
		System.out.print("Ingrese el id del libro: ");
		int id = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Ingrese título del libro: ");
		String titulo = teclado.nextLine();
		System.out.print("Ingrese año de publicación: ");
		int anyoPublicacion = teclado.nextInt();
		teclado.nextLine(); // Consume newline
		System.out.print("Ingrese autor del libro: ");
		String autor = teclado.nextLine();
		System.out.print("Ingrese editorial del libro: ");
		String editorial = teclado.nextLine();
	
		Libro libro = new Libro(id,titulo,anyoPublicacion, autor, editorial,false);
		libro.guardarEnBaseDeDatos();
		
	}
	
	public void prestarLibro(Scanner scanner) {
		System.out.print("Ingrese el id del libro a prestar: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Libro l = Libro.leerLibroBD(id);
		l.prestar();
		l.guardarEnBaseDeDatos();
		
		
	}
	
	public void devolverLibro(Scanner scanner) {
		System.out.print("Ingrese el id del libro a devolver: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Libro l = Libro.leerLibroBD(id);
		l.devolver();
		l.guardarEnBaseDeDatos();
		
		
	}

	public void agregarRevista(Scanner teclado) {
		System.out.print("Ingrese el id de la revista: ");
		int id = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Ingrese título de la revista: ");
		String titulo = teclado.nextLine();
		System.out.print("Ingrese año de publicación: ");
		int anyoPublicacion = teclado.nextInt();
		teclado.nextLine(); // Consume newline
		System.out.print("Ingrese periodicidad de la revista: ");
		String periodicidad = teclado.nextLine();
		System.out.print("Ingrese tema de la revista: ");
		String tema = teclado.nextLine();
	
		Revista r = new Revista(id,titulo,anyoPublicacion,periodicidad,tema);
		r.guardarEnBaseDeDatos();		
	}
}
