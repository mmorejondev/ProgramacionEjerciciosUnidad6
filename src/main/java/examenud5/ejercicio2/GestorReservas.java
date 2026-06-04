package examenud5.ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import examenud5.ejercicio1.Curso;

public class GestorReservas {

	private Map<String, Reserva> reservas;
	Scanner teclado;
	public GestorReservas() {
		this.reservas = new HashMap<>();
		this.teclado = new Scanner(System.in);
	}

	public Map<String, Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}

	public void mostrarReservas() {

		for (String clave: this.reservas.keySet()) {
			System.out.println(clave);
			System.out.println(this.reservas.get(clave));
			System.out.println("______________________________________________");
			
		}
	}

	public void eliminarReserva(String idEliminar) {
		this.reservas.remove(idEliminar);
	}

	public void anadirReserva() throws ReservaDuplicadaException{
		System.out.println("Introduzca id: ");
		String idNuevo = this.teclado.nextLine();
		if (this.reservas.containsKey(idNuevo)) {
			throw new ReservaDuplicadaException("Reserva Duplicada");
		}else {//La reserva no existe, podemos incluirla
			System.out.println("Introduzca aula: ");
			String aula = this.teclado.nextLine();
			System.out.println("Introduzca profesor: ");
			String profesor = this.teclado.nextLine();
			System.out.println("Introduzca fecha: ");
			String fecha = this.teclado.nextLine();
			System.out.println("Introduzca hora: ");
			String hora = this.teclado.nextLine();
			System.out.println("Introduzca duracion: ");
			int duracion = this.teclado.nextInt();
			this.teclado.nextLine();
			
			this.reservas.put(idNuevo, new Reserva(idNuevo, aula, profesor, fecha, hora, duracion));
			
		}
		

		
		
		
		
		
		
	}

	public void crearArchivoTexto() {
		File archivoTextoSalida = new File("ListadoEj2.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTextoSalida))){
		for (Reserva r: this.reservas.values()) {
			bw.write("Codigo: " + r.getId());
			bw.newLine();
			bw.write("Aula:" + r.getAula());
			bw.newLine();
			bw.write("Profesor: " + r.getProfesor());
			bw.newLine();
			bw.write("Fecha: " + r.getFecha() + " - Hora: " + r.getHora());
			bw.newLine();
			bw.write("Duración: " + r.getDuracion());
			bw.newLine();
			bw.newLine();
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
