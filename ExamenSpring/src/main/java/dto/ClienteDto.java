package dto;

import lombok.Value;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import java.io.Serializable;

/**
 * DTO for {@link entidades.Cliente}
 */
@Value
public class ClienteDto implements Serializable {
    Integer id;
    //@Pattern("[a-zá-zA-ZÁ-Z]{3,10}")
    @NotNull()
    String nombre;
    String apellido;
    String nickname;
    //@Pattern("![0-9]![a-z]![A-Z]")
    //@Size(min=6,max=10)
    String password;
    //@Pattern("^(69){1}[0-9]{8}$")
    String telefono;
    String domicilio;
}