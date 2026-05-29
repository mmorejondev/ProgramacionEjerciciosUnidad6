package examenud5.ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	
	
	
	
	
	
}
