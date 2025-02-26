package org.example.examenspring.dto;

import lombok.Value;
import org.example.examenspring.entidades.Devolucione;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Devolucione}
 */
@Value
public class DevolucioneDto implements Serializable {
    Integer id;
    Integer clienteId;
    Integer productoId;
    LocalDate fecha;
    Integer cantidad;
    String motivo;

    public Integer getId() {
        return id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public DevolucioneDto(Integer id, Integer clienteId, Integer productoId, LocalDate fecha, Integer cantidad, String motivo) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }
}