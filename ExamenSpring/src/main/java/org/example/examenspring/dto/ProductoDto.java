package org.example.examenspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Value;
import org.example.examenspring.entidades.Producto;

import java.io.Serializable;

/**
 * DTO for {@link Producto}
 */
@Data
@Value
public class ProductoDto implements Serializable {
    Integer id;
    @Pattern(regexp = "[a-zA-Z0-9]")
    String nombre;
    String descripcion;
    @Min(0)
    Float precio;
    Integer stock;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public ProductoDto(Integer id, String nombre, String descripcion, Float precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
}