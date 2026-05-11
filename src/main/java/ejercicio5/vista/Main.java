package ejercicio5.vista;

import java.util.Scanner;

import ejercicio5.controlador.Controlador;

public class Main {

	public static void main(String args []) {
	Scanner scanner = new Scanner(System.in);
	int opcion=0;
	Controlador controlador = new Controlador();
	
	do {
    	System.out.println("\nBienvenido al Sistema de Gestión de la Biblioteca");
    	System.out.println("1. Agregar libro");
    	System.out.println("2. Agregar revista");
    	System.out.println("3. Prestar libro");
    	System.out.println("4. Devolver libro");
    	System.out.println("5. Salir");
    	System.out.print("Seleccione una opción: ");
    	opcion = scanner.nextInt();
    	scanner.nextLine(); 
    	switch (opcion) {
        	case 1:
        		controlador.agregarLibro(scanner);
            	break;
        	case 2:
            	//agregarRevista(scanner);
            	break;
        	case 3:
            	controlador.prestarLibro(scanner);
            	break;
        	case 4:
            	//devolverLibro(scanner);
            	break;
        	case 5:
            	System.out.println("Saliendo del sistema...");
            	break;
        	default:
            	System.out.println("Opción no válida. Por favor intente de nuevo.");
            	break;
    	}
	} while (opcion != 5);

	scanner.close();
	}
	
}


