package org.example.examenspring.controladores;

import org.example.examenspring.dto.ProductoDto;
import org.example.examenspring.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.examenspring.repos.ProductoRepository;
import org.example.examenspring.servicio.Servicio;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoControler {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    Servicio servicio;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> obtenerProducto(){
        ArrayList<ProductoDto> productos = new ArrayList<>();
        for (Producto producto : productoRepository.findAll()) {
            productos.add(servicio.crearProductoDto(producto));
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDto productoDto){
        return ResponseEntity.ok(productoRepository.save(servicio.crearDeDto(productoDto)));
    }
    @PutMapping()
    public ResponseEntity<Producto> actualizarProducto(@RequestBody ProductoDto productoDto){
        if(productoRepository.findById(productoDto.getId()).isPresent()){
            return ResponseEntity.ok(productoRepository.save(servicio.crearDeDto(productoDto)));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
