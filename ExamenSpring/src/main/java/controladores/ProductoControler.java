package controladores;

import dto.ProductoDto;
import entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repos.ProductoRepository;
import servicio.Servicio;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoControler {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    Servicio servicio;

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProducto(){
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDto productoDto){
        return ResponseEntity.ok(productoRepository.save(servicio.crearDeDto(productoDto)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDto productoDto){
        if(productoRepository.findById(productoDto.getId()).isPresent()){
            return ResponseEntity.ok(productoRepository.save(servicio.crearDeDto(productoDto)));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
