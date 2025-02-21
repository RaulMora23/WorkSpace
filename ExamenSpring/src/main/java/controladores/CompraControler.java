package controladores;

import dto.CompraDto;
import entidades.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.CompraRepository;
import servicio.Servicio;

@RestController
@RequestMapping("/compra")
public class CompraControler {

    @Autowired
    Servicio servicio;

    @Autowired
    CompraRepository repository;

    @PostMapping
    public ResponseEntity<Compra> realizarCompra(@RequestBody CompraDto dto){
        if(servicio.validarCompra(dto)){
            servicio.crearDeDto(dto);
            return ResponseEntity.ok(repository.save(servicio.crearDeDto(dto)));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
