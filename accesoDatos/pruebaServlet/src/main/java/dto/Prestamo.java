package dto;

import dao.*;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "Prestamo")
public class Prestamo implements Comparable<Prestamo> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;


    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    @Transient
    private int ejemplarID;
    @Transient
    private int usuarioID;

    public Prestamo() {};

    public Prestamo(int idUsuario, int idEjemplar) {
        setUsuario(idUsuario);
        setEjemplar(idEjemplar);
        setFechaInicio();
    }
    public Prestamo(int id,int idUsuario, int idEjemplar) {
        setId(id);
        setUsuario(idUsuario);
        setUsuarioID();
        setEjemplar(idEjemplar);
        setEjemplarID();
        setFechaInicio();
    }

    public Prestamo(Object instancia) {
        Prestamo prestamo = (Prestamo) instancia;
        this.id = prestamo.getId();
        this.usuario = prestamo.getUsuario();
        this.ejemplar = prestamo.getEjemplar();
        this.fechaInicio = prestamo.getFechaInicio();
        this.fechaDevolucion = prestamo.getFechaDevolucion();
    }

    public Prestamo(ArrayList<String> valores) {
        setUsuario(Integer.parseInt(valores.get(0)));
        setUsuarioID();
        setEjemplar(Integer.parseInt(valores.get(1)));
        setEjemplarID();
        setFechaInicio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(int idUsuario) {
        this.usuario = (Usuario) new UsuarioDao().read(idUsuario);
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID() {
        this.usuarioID = usuario.getId();
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(int idEjemplar) {
        this.ejemplar = (Ejemplar) new EjemplarDao().read(idEjemplar);
    }

    public int getEjemplarID() {
        return ejemplarID;
    }

    public void setEjemplarID() {
        this.ejemplarID = ejemplar.getId();
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio() {
        this.fechaInicio = LocalDate.now();
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean setFechaDevolucion() {
        if (fechaDevolucion == null) {
            this.fechaDevolucion = LocalDate.now();
            getEjemplar().setEstado("DISPONIBLE");
            getEjemplar().actualizarRegistro();
            return fechaDevolucion.isAfter(fechaInicio.plusDays(15));
        }
        return false;
    }

    public void actualizarRegistro(){
        DAO dao = new PrestamoDao();
        dao.update(new ObjetoGenerico(this, getClass()));
    }

    @Override
    public String toString() {
        return "Prestamo:" +
                "id=" + id +
                ", usuario=" + usuario.getId() +
                ", ejemplar=" + ejemplar.getIsbn().getTitulo() +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion;
    }

    @Override
    public int compareTo(Prestamo o) {
        return id.compareTo(o.getId());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return (Objects.equals(id, prestamo.getId()) && Objects.equals(usuarioID, prestamo.getUsuarioID()) &&
                Objects.equals(ejemplarID,prestamo.getEjemplarID()) && fechaInicio.equals(prestamo.getFechaInicio()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioID, ejemplarID, fechaInicio);
    }
    public ArrayList<String> getValores() {
        ArrayList<String> valores = new ArrayList<>();
        valores.add(String.valueOf(usuarioID));
        valores.add(String.valueOf(ejemplarID));
        valores.add(String.valueOf(fechaInicio));
        return valores;
    }
}