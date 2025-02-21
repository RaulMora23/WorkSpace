package dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link entidades.Compra}
 */
@Value
public class CompraDto implements Serializable {
    Integer id;
    Integer clienteId;
    Integer productoId;
    LocalDate fecha;
    Float importe;
    Integer cantidad;
}