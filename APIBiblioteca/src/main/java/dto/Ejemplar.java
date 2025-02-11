package dto;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "isbn", nullable = false)
    private dto.Libro isbn;

    @Lob
    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "ejemplar")
    private Set<dto.Prestamo> prestamos = new LinkedHashSet<>();

    private static Set<String> estados = Set.of("DISPONIBLE", "PRESTADO", "DAÑADO");

    public Ejemplar() {
    }
}
