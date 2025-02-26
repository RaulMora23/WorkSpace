package org.example.examenspring.controladores;

import org.example.examenspring.dto.CompraDto;
import org.example.examenspring.entidades.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.examenspring.repos.CompraRepository;
import org.example.examenspring.servicio.Servicio;

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
            return ResponseEntity.ok(repository.save(servicio.crearDeDto(dto)));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
