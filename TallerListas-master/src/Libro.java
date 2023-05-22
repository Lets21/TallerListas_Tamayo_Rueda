public class Libro {
    private int idLibro;
    private String nombre;
    private int numPag;

    public Libro(String nombre, int numPag) {
        this.nombre = nombre;
        this.numPag = numPag;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
}
