package dto;

import dao.DAO;
import dao.LibroDao;
import dao.ObjetoGenerico;
import dao.UsuarioDao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Libro")
public class Libro implements Comparable<Libro> {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @OneToMany(mappedBy = "isbn")
    private Set<Ejemplar> ejemplares = new LinkedHashSet<>();

    public Libro() {};

    public Libro(String isbn, String titulo, String autor) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
    }
    public Libro(Object o){
        Libro libro = (Libro) o;
        setIsbn(libro.getIsbn());
        setTitulo(libro.getTitulo());
        setAutor(libro.getAutor());
        this.ejemplares.addAll(libro.getEjemplares());
    }
    public Libro(ArrayList<String> valores){
        setIsbn(valores.get(0));
        setTitulo(valores.get(1));
        setAutor(valores.get(2));
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Set<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Set<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplaresDisponibles() {
        int ejemplaresDisponibles = 0;
        for (Ejemplar e : ejemplares) {
            if (e.getEstado().equals("DISPONIBLE")) {
                ejemplaresDisponibles++;
            }
        }
        return ejemplaresDisponibles;
    }

    public void actualizarRegistro(){
        DAO dao = new LibroDao();
        dao.update(new ObjetoGenerico(this, getClass()));
    }

    @Override
    public String toString() {
        return "Libro:" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ejemplares=" + ejemplares.size() +
                ", disponibles=" + getEjemplaresDisponibles();
    }

    @Override
    public int compareTo(Libro o) {
        return isbn.compareTo(o.getIsbn());
    }
}