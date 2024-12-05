package dto;

import dao.DAO;
import dao.ObjetoGenerico;
import dao.PrestamoDao;
import dao.UsuarioDao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

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

    private static Set<String> tipos = Set.of("administrador", "normal");

    public Usuario() {};

    public Usuario(String dni, String nombre, String email, String password, String tipo) {
        setDni(dni);
        setNombre(nombre);
        setEmail(email);
        setPassword(password);
        setTipo(tipo);
        setPrestamos();
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
        if(tipos.contains(tipo)) {
            this.tipo = tipo;
        }
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

    public void setPrestamos() {
        DAO dao = new PrestamoDao();
        ArrayList<Prestamo> arrayList = dao.readBy("usuario_id",String.valueOf(id));
        prestamos.clear();
        prestamos.addAll(arrayList);
    }

    public void actualizarRegistro(){
        DAO dao = new UsuarioDao();
        dao.update(new ObjetoGenerico(this, getClass()));
    }
    //Si da true hay penalizacion
    public boolean devolverPrestamo(Prestamo prestamo) {
        boolean sancion = false;
        if(this.prestamos.contains(prestamo)||this.tipo.equals("administrador")) {
            System.out.println("Esta contenido");
           sancion = prestamo.setFechaDevolucion();
           prestamo.actualizarRegistro();
           if (sancion) {
               if (this.getPenalizacionHasta()==null){
                   this.setPenalizacionHasta(LocalDate.now().plusDays(15));
               }else{
                   this.setPenalizacionHasta(getPenalizacionHasta().plusDays(15));
               }
               actualizarRegistro();
               return true;
           }
           return false;
       }
       return false;
    }

    public boolean adquirirPrestamo(String isbn) {
        if (LocalDate.now().isAfter(getPenalizacionHasta())||penalizacionHasta==null){
            DAO dao = new PrestamoDao();
            ArrayList<Prestamo> arrayList = (ArrayList<Prestamo>) dao.readBy(List.of("isbn", "estado"),List.of(isbn, "DISPONIBLE")).getFirst();
            return true;
        }else{
            return false;
        }
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.getId()) && dni.equals(usuario.getDni()) && nombre.equals(usuario.getNombre()) && email.equals(usuario.getEmail()) && password.equals(usuario.getPassword()) && tipo.equals(usuario.getTipo()) && penalizacionHasta.equals(usuario.getPenalizacionHasta());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, email, password, tipo, penalizacionHasta);
    }

}