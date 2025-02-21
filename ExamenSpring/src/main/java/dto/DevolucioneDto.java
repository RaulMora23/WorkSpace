package dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link entidades.Devolucione}
 */
@Value
public class DevolucioneDto implements Serializable {
    Integer id;
    Integer clienteId;
    Integer productoId;
    LocalDate fecha;
    Integer cantidad;
    String motivo;
}