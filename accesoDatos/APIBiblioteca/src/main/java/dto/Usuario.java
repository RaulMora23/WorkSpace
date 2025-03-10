package dto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

    @OneToMany(mappedBy = "usuario")
    private Set<Prestamo> prestamos = new LinkedHashSet<>();

    private static Set<String> tipos = Set.of("administrador", "normal");

    public Usuario() {
    }

    ;
}
