package dto;

import dao.*;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Ejemplar")
public class Ejemplar implements Comparable<Ejemplar> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "isbn", nullable = false)
    private dto.Libro isbn;

    @ColumnDefault("'Disponible'")
    @Lob
    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "ejemplar")
    private Set<dto.Prestamo> prestamos = new LinkedHashSet<>();

    private static Set<String> estados = Set.of("DISPONIBLE","PRESTADO","DAÑADO");

    public Ejemplar() {}

    public Ejemplar(int id, String isbn, String estado) {
        setId(id);
        setIsbn(isbn);
        setEstado(estado);
    }
    public Ejemplar(String isbn, String estado) {
        setIsbn(isbn);
        setEstado(estado);
    }
    public Ejemplar(Object o){
        Ejemplar e = (Ejemplar) o;
        setId(e.getId());
        setEstado(e.getEstado());
        this.isbn = e.getIsbn();
        this.prestamos=e.getPrestamos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public dto.Libro getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = (Libro) new LibroDao().read(isbn).getInstancia();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estados.contains(estado.toUpperCase())) {
            this.estado = estado.toUpperCase();
        }
    }

    public Set<dto.Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<dto.Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void actualizarRegistro(){
        DAO dao = new EjemplarDao();
        dao.update(new ObjetoGenerico(this, getClass()));
    }

    @Override
    public String toString() {
        return "Ejemplar:" +
                "id=" + id +
                ", isbn=" + isbn.getTitulo() +
                ", estado='" + estado;
    }

    @Override
    public int compareTo(Ejemplar o) {
        return id.compareTo(o.getId());
    }
}