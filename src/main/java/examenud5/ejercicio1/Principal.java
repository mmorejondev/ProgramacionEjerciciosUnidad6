package examenud5.ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main(String[] args) {

		File archivo = new File("cursos.json");
		File archivoFiltrado = new File("cursos_Java_online_largos.json");
		File archivoTextoSalida = new File ("informe_cursos_Java_largos_online.txt");
		ObjectMapper mapeador = new ObjectMapper();
		

			try {
				List<Curso> listacursos = new ArrayList<>(); 
				listacursos=mapeador.readValue(archivo, new TypeReference<List<Curso>>(){});
				/*for (Curso c: listacursos)
					System.out.println(c);
				*/
				for (Curso c: listacursos){
					if (c.getProfesor().equals("Laura"))
						c.setProfesor("Lucía");
				}
				System.out.println("Lista de cursos actualizada.");
				for (Curso c: listacursos)
					System.out.println(c);
				
				//guardando en disco
				mapeador.writeValue(archivo,listacursos);
				System.out.println("Archivo actualizado correctamente.");
				
				listacursos=mapeador.readValue(archivo, new TypeReference<List<Curso>>(){});
				List<Curso> listaFiltrada = new ArrayList<>(); 
				
				for (Curso c: listacursos) {
					if (c.getModalidad().equals("Online") && c.getHoras()>45 && c.getNombre().contains("Java")) {
						listaFiltrada.add(c);
					}
				}
				
				System.out.println("Lista de cursos filtrados");
				for (Curso c: listaFiltrada)
					System.out.println(c);
				
				
				
				Collections.sort(listaFiltrada, new ComparadorHoras());
				
				//Creamos el archivo de salida filtrado
				mapeador.writeValue(archivoFiltrado, listaFiltrada);

				System.out.println("Archivo con filtro creado correctamente.");
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTextoSalida));
				for (Curso c: listaFiltrada) {
					bw.write("Nombre del curso: " + c.getNombre());
					bw.newLine();
					bw.write("Profesor: " + c.getProfesor());
					bw.newLine();
					bw.write("Duración: " + c.getHoras());
					bw.newLine();
					bw.write("Precio: " + c.getPrecio());
					bw.newLine();
					bw.write("Modalidad: " + c.getModalidad());
					bw.newLine();
					bw.newLine();
					
				}
				bw.close();
				
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

}
