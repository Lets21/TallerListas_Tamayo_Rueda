import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(String nombre, int numPag) {
        if (!existeLibroPorNombre(nombre)) {
            Libro libro = new Libro(nombre, numPag);
            libros.add(libro);
            ordenarLibrosPorId();
            JOptionPane.showMessageDialog(null,"Se ha ingresado el libro exitosamente");
        } else {
            JOptionPane.showMessageDialog(null,"Ya existe un libro con el mismo nombre.");
        }
    }

    public void eliminarLibroPorId(int idLibro) {
        Libro libro = buscarLibroPorId(idLibro);
        if (libro != null) {
            libros.remove(libro);
            JOptionPane.showMessageDialog(null,"Se elimino el libro exitosamente");
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró un libro con el ID especificado.");
        }
    }

    public void eliminarLibroPorNombre(String nombreLibro) {
        Libro libro = buscarLibroPorNombre(nombreLibro);
        if (libro != null) {
            libros.remove(libro);
            JOptionPane.showMessageDialog(null,"Se elimino el libro exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un libro con el nombre especificado.");
        }
    }

    public Libro buscarLibroPorId(int idLibro) {
        ordenarLibrosPorId();
        int indice = busquedaBinariaPorId(idLibro);
        if (indice != -1) {
            JOptionPane.showMessageDialog(null,"El libro es: " +libros.get(indice));
            return libros.get(indice);
        }
        JOptionPane.showMessageDialog(null,"No se encontro ningun libro");
        return null;
    }

    public Libro buscarLibroPorNombre(String nombreLibro) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                JOptionPane.showMessageDialog(null,"El libro es: " +libro);
                return libro;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontro ningun libro");
        return null;
    }

    public int calcularTotalPaginas() {
        return calcularTotalPaginasRecursivo(libros.size() - 1);
    }

    private int calcularTotalPaginasRecursivo(int indice) {
        if (indice < 0) {
            return 0;
        }
        return libros.get(indice).getNumPag() + calcularTotalPaginasRecursivo(indice - 1);
    }

    private void ordenarLibrosPorId() {
        Collections.sort(libros, (libro1, libro2) -> Integer.compare(libro1.getIdLibro(), libro2.getIdLibro()));
    }

    private boolean existeLibroPorNombre(String nombreLibro) {
        for (Libro libro : libros) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                return true;
            }
        }
        return false;
    }

    private int busquedaBinariaPorId(int idLibro) {
        int inicio = 0;
        int fin = libros.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Libro libro = libros.get(medio);

            if (libro.getIdLibro() == idLibro) {
                return medio;
            }

            if (libro.getIdLibro() < idLibro) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1; // No se encontró el libro
    }
}