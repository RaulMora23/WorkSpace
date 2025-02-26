package org.example.examenspring.dto;

import lombok.Value;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.examenspring.entidades.Cliente;

import java.io.Serializable;

/**
 * DTO for {@link Cliente}
 */
@Value
public class ClienteDto implements Serializable {
    Integer id;
    //@Pattern("[a-zá-zA-ZÁ-Z]{3,10}")
    @NotNull
    String nombre;
    String apellido;
    String nickname;
    //@Pattern("![0-9]![a-z]![A-Z]")
    //@Size(min=6,max=10)
    String password;
    //@Pattern("^(69){1}[0-9]{8}$")
    String telefono;
    String domicilio;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
