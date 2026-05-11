package ejercicio5.modelo;

public abstract class Item {

	int id;
	String titulo;
	int anyoPublicacion;
	
	public Item(int id, String titulo, int anyoPublicacion) {
		this.id = id;
		this.titulo = titulo;
		this.anyoPublicacion = anyoPublicacion;
	}
	
	public abstract void guardarEnBaseDeDatos();
	
	

}
