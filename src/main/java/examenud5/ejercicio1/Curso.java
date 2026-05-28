package examenud5.ejercicio1;

public class Curso{

	String nombre;
	String profesor;
	int horas;
	double precio;
	String modalidad;
	
	public Curso(String nombre, String profesor, int horas, double precio, String modalidad) {
	
		this.nombre = nombre;
		this.profesor = profesor;
		this.horas = horas;
		this.precio = precio;
		this.modalidad = modalidad;
	}
	public Curso() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", profesor=" + profesor + ", horas=" + horas + ", precio=" + precio
				+ ", modalidad=" + modalidad + "]";
	}
	

}
