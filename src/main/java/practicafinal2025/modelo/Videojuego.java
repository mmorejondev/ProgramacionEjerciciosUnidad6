package practicafinal2025.modelo;

public class Videojuego {
    private String id;
    private String titulo;
    private String plataforma;
    private Double precio;

    // Constructor vacío obligatorio para frameworks
    public Videojuego() {}

    // Constructor completo para inicializar datos
    public Videojuego(String id, String titulo, String plataforma, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    // Métodos Getter y Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Videojuego{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                '}';
    }
}
