package dto;

import dao.DAO;
import dao.ObjetoGenerico;
import dao.PrestamoDao;
import dao.UsuarioDao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario implements Comparable<Usuario> {
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

    public Usuario() {};

    public Usuario(String dni, String nombre, String email, String password, String tipo) {
        setDni(dni);
        setNombre(nombre);
        setEmail(email);
        setPassword(password);
        setTipo(tipo);
    }

    public Usuario(Integer id, String dni, String nombre, String email, String password, String tipo) {
        setId(id);
        setDni(dni);
        setNombre(nombre);
        setEmail(email);
        setPassword(password);
        setTipo(tipo);
    }

    public Usuario(Object o){
        Usuario usuario = (Usuario) o;
        this.id = usuario.getId();
        this.dni = usuario.getDni();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        this.tipo = usuario.getTipo();
        this.prestamos=usuario.getPrestamos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(LocalDate penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void actualizarRegistro(){
        DAO dao = new UsuarioDao();
        dao.update(new ObjetoGenerico(this, getClass()));
    }
    //Si da true hay penalizacion
    public boolean devolverPrestamo(Prestamo prestamo) {
        boolean sancion = false;
        if(this.prestamos.contains(prestamo)) {
            System.out.println("Esta contenido");
           sancion = prestamo.setFechaDevolucion();
           if (sancion) {
               if (this.getPenalizacionHasta()==null){
                   this.setPenalizacionHasta(LocalDate.now().plusDays(15));
               }else{
                   this.setPenalizacionHasta(getPenalizacionHasta().plusDays(15));
               }
               return true;
           }
           return false;
       }
       return false;
    }

    @Override
    public String toString() {
        return "Usuario:" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", penalizacionHasta=" + penalizacionHasta;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.dni.compareTo(o.getDni());
    }
    @Override
    public boolean equals(Object o) {
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.getId()) && dni.equals(usuario.getDni()) && nombre.equals(usuario.getNombre()) && email.equals(usuario.getEmail()) && password.equals(usuario.getPassword()) && tipo.equals(usuario.getTipo()) && penalizacionHasta.equals(usuario.getPenalizacionHasta());
    }

}