package practicafinal2025MVC.vista;
import practicafinal2025MVC.controlador.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import practicafinal2025MVC.modelo.ConectorBaseDatos;
import practicafinal2025MVC.modelo.Videojuego;

public class Principal {

	public static void main(String[] args) {

		
		Controlador controlador = new Controlador();
		
		
		/*
		List<Videojuego> filtradosPrecio = controlador.filtrarPorPrecio();
		for (Videojuego v: filtradosPrecio)
			System.out.println(v);
		
		List<Videojuego> filtradosPlataforma = controlador.filtrarPorPlataforma();
		for (Videojuego v: filtradosPlataforma)
			System.out.println(v);
		*/
		//controlador.insertarNuevoVideojuego();
		//controlador.borrarVideojuego();
		controlador.modificarPrecioVideojuegoPorId();
				
		
	}

}
