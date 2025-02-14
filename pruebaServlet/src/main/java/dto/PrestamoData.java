package dto;

import java.sql.Date;
import java.time.LocalDate;

public class PrestamoData {

    private Integer id;

    private int usuario_id;

    private int ejemplar_id;

    private LocalDate fechaInicio;

    private LocalDate fechaDevolucion;


    public PrestamoData(Prestamo o) {
        id = o.getId();
        usuario_id=o.getUsuario().getId();
        ejemplar_id=o.getEjemplar().getId();
        fechaInicio=o.getFechaInicio();
        fechaDevolucion=o.getFechaDevolucion();
    }

    public Date getFechaDevolucion() {
        if (fechaDevolucion!=null) {
            return Date.valueOf(fechaDevolucion);
        }else{
            return null;
        }
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getFechaInicio() {
        return Date.valueOf(fechaInicio);
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(int ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
