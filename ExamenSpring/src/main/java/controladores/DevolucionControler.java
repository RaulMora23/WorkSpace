package controladores;

import dto.DevolucioneDto;
import entidades.Devolucione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.DevolucioneRepository;
import servicio.Servicio;

@RestController
@RequestMapping("/devolucion")
public class DevolucionControler {

    @Autowired
    Servicio servicio;

    @Autowired
    DevolucioneRepository repository;

    @PostMapping
    public ResponseEntity<Devolucione> realizarDevolucion( @RequestBody DevolucioneDto dto){
        if(servicio.validarDevolucion(dto)){
            servicio.crearDeDto(dto);
            return ResponseEntity.ok(repository.save(servicio.crearDeDto(dto)));
        }else{
            return ResponseEntity.badRequest().build();
        }

    }
}
