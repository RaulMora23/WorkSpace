package org.example.examenspring.dto;

import lombok.Value;
import org.example.examenspring.entidades.Compra;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Compra}
 */
@Value
public class CompraDto implements Serializable {
    Integer id;
    Integer clienteId;
    Integer productoId;
    LocalDate fecha;
    Float importe;
    Integer cantidad;

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

    public Float getImporte() {
        return importe;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public CompraDto(Integer id, Integer clienteId, Integer productoId, LocalDate fecha, Float importe, Integer cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.fecha = fecha;
        this.importe = importe;
        this.cantidad = cantidad;
    }
}