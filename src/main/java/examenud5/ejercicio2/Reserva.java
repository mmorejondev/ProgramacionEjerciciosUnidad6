package examenud5.ejercicio2;

public class Reserva {

	String id;
	String aula;
	String profesor;
	String fecha;
	String hora;
	int duracion;
	
	public Reserva(String id, String aula, String profesor, String fecha, String hora, int duracion) {
		this.id = id;
		this.aula = aula;
		this.profesor = profesor;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
	}
	
	public Reserva() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", aula=" + aula + ", profesor=" + profesor + ", fecha=" + fecha + ", hora=" + hora
				+ ", duracion=" + duracion + "]";
	}
	
	
	


}
