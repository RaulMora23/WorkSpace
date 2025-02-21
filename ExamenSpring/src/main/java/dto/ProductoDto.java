package dto;

import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Value;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.processing.Pattern;

import java.io.Serializable;

/**
 * DTO for {@link entidades.Producto}
 */
@Data
@Value
public class ProductoDto implements Serializable {
    Integer id;
    //@Pattern("[a-zA-Z0-9]")
    String nombre;
    String descripcion;
    //@Min(0)
    Float precio;
    Integer stock;
}