package dto;

import dao.EjemplarDao;
import dao.UsuarioDao;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private dto.Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    public Prestamo() {};

    public Prestamo(int idUsuario, int idEjemplar, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        setUsuario(idUsuario);
        setEjemplar(idEjemplar);
        setFechaInicio(fechaInicio);
        setFechaDevolucion(fechaDevolucion);
    }
    public Prestamo(int id,int idUsuario, int idEjemplar, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        setId(id);
        setUsuario(idUsuario);
        setEjemplar(idEjemplar);
        setFechaInicio(fechaInicio);
        setFechaDevolucion(fechaDevolucion);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public dto.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(int idUsuario) {
        this.usuario = (Usuario) new UsuarioDao().read(idUsuario).getInstancia();
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(int idEjemplar) {
        this.ejemplar = (Ejemplar) new EjemplarDao().read(idEjemplar).getInstancia();
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}