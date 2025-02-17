package dto;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Data
@Entity
public class Prestamo implements Comparable<Prestamo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaDevolucion;

    public Prestamo() {
        this.fechaInicio = LocalDate.now();
    }

    public Prestamo(Usuario usuario, Ejemplar ejemplar) {
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.fechaInicio = LocalDate.now();
    }

    @Override
    public int compareTo(Prestamo o) {
        return id.compareTo(o.getId());
    }
}
