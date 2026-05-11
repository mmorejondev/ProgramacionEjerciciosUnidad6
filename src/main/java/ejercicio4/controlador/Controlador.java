package ejercicio4.controlador;
import java.util.List;

import ejercicio4.modelo.Empleado;
import ejercicio4.modelo.Modelo;

public class Controlador {

	public List<Empleado> leerDatos() {
		Modelo md = new Modelo();
		List<Empleado> l = md.leerDatos();
		return l;
	}
	
	public float calcularEdadMedia(List<Empleado> l) {
		
		float edadMedia=0.0f;
		float sumaEdades=0.0f;
		for (Empleado e: l) {
			sumaEdades=sumaEdades + e.getEdad();
		}
		edadMedia = (int) sumaEdades/l.size();
		return edadMedia;
		
	}
	
	public Empleado encontrarMasJoven(List<Empleado> l) {
		
		/*Partimos de que el empleado es el primero de la lista*/
		Empleado empleadoMasJoven = l.get(0);
		
		for (Empleado e: l) {
			if (e.getEdad()<empleadoMasJoven.getEdad()) {
				empleadoMasJoven=e;
			}
		}
		return empleadoMasJoven;
		
	}
}