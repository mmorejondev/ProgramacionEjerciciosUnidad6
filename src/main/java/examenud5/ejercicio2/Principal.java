package examenud5.ejercicio2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main(String[] args) {

		GestorReservas gr = new GestorReservas();
		ObjectMapper mapeador = new ObjectMapper();
		File archivoEntrada = new File("reservas.json");
		File archivoSalida = new File("reservas_por_profesor.json");
		
		int opcion=0;
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduzca la opción: ");
		System.out.println("1.- Añadir Reserva");
		System.out.println("2.- Eliminar Reserva");
		System.out.println("3.- Mostrar reservas");
		System.out.println("4.- Generar archivo de texto");
		System.out.println("5.- Generar JSON de profesores");
		System.out.println("6.- Salir");
		opcion=teclado.nextInt();
		teclado.nextLine();
		
		
		while(opcion!=6) {
		
			if (opcion==1) {
				try {
					gr.setReservas(mapeador.readValue(archivoEntrada, new TypeReference<Map<String,Reserva>>(){}));
					try {
						gr.anadirReserva();
						mapeador.writeValue(archivoEntrada, gr.getReservas());
					} catch (ReservaDuplicadaException e) {
						System.out.println(e.getMessage());
					}
				} catch (StreamReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabindException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if (opcion==2) {
				try {
					gr.setReservas(mapeador.readValue(archivoEntrada, new TypeReference<Map<String,Reserva>>(){}));
					System.out.println("Introduzca id de reserva a eliminar: ");
					String idEliminar = teclado.nextLine();
					gr.eliminarReserva(idEliminar);
					mapeador.writeValue(archivoEntrada, gr.getReservas());
					
				} catch (StreamReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabindException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
			}
			else if (opcion==3) {
				try {
				
					gr.setReservas(mapeador.readValue(archivoEntrada, new TypeReference<Map<String,Reserva>>(){}));	
					gr.mostrarReservas();
								
				} catch (StreamReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabindException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (opcion==4) {
				//Equivalente al ejercicio 1, pero recorriendo el mapa.
			}else if (opcion==5) {
				try {
					gr.setReservas(mapeador.readValue(archivoEntrada, new TypeReference<Map<String,Reserva>>(){}));
					Set<String> nombresProfe = new HashSet<>();
					for (String clave: gr.getReservas().keySet()) {
						Reserva r = gr.getReservas().get(clave);
						nombresProfe.add(r.getProfesor());
					}
					Map<String, List<Reserva>> mapaProfeReservas = new HashMap<>();
					for (String nombreProfe: nombresProfe) {
						mapaProfeReservas.put(nombreProfe, new ArrayList<>());
					}
					
										
					for (String nombreProfe: nombresProfe) {
						List<Reserva> listaPorProfe = new ArrayList<>();
						for (String clave: gr.getReservas().keySet()) {
							Reserva r = gr.getReservas().get(clave);
							if (nombreProfe.equals(r.getProfesor())) {
								listaPorProfe.add(r);
								mapaProfeReservas.put(nombreProfe,listaPorProfe);
							}
						}
							
					}
					/*Para comprobar que el mapa se ha creado correctamente
					System.out.println("Lista agrupado por profesor");
					for (String nombre: mapaProfeReservas.keySet()) {
						System.out.println(nombre);
						for (Reserva r: mapaProfeReservas.get(nombre))
							System.out.println(r);
					}
					*/
					mapeador.writeValue(archivoSalida, mapaProfeReservas);
				
				} catch (StreamReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabindException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

			}
			
		
			System.out.println("Introduzca la opción: ");
			System.out.println("1.- Añadir Reserva");
			System.out.println("2.- Eliminar Reserva");
			System.out.println("3.- Mostrar reservas");
			System.out.println("4.- Generar archivo de texto");
			System.out.println("5.- Generar JSON de profesores");
			System.out.println("6.- Salir");
			opcion=teclado.nextInt();
			teclado.nextLine();
									
		}
		
		System.out.println("Programa terminado.");
	}

}
