package org.example.examenspring.servicio;

import org.example.examenspring.dto.CompraDto;
import org.example.examenspring.dto.DevolucioneDto;
import org.example.examenspring.dto.ProductoDto;
import org.example.examenspring.entidades.Compra;
import org.example.examenspring.entidades.Devolucione;
import org.example.examenspring.entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.examenspring.repos.ClienteRepository;
import org.example.examenspring.repos.CompraRepository;
import org.example.examenspring.repos.DevolucioneRepository;
import org.example.examenspring.repos.ProductoRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Servicio {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    DevolucioneRepository devolucioneRepository;

    public boolean validarCompra(CompraDto compraDto){
        Optional<Producto> productoNull = productoRepository.findById(compraDto.getProductoId());
        Producto producto =productoNull.get();
        if(producto.getStock()<compraDto.getCantidad()){
            return false;
        }else{
            //Control de stock
            producto.setStock(producto.getStock()-compraDto.getCantidad());
            return true;
        }
    }
    public boolean validarDevolucion(DevolucioneDto devolucioneDto){
        Compra miCompra = new Compra();
        ArrayList<Compra> lista = (ArrayList<Compra>) compraRepository.findAll();
        for(Compra compra : lista){
            //Nos aseguramos que coincidan los campos
            if(compra.getProducto().getId()==devolucioneDto.getProductoId()&&compra.getCliente().getId()==devolucioneDto.getClienteId()&&compra.getCantidad()==devolucioneDto.getCantidad()){
                if(miCompra==null){
                    miCompra = compra;
                }
                //Obtenemos la última compra que coincida
                if (compra.getFecha().isAfter(miCompra.getFecha())){
                    miCompra = compra;
                };
            }
        }
        //Comprobamos validacion
        if(miCompra.getFecha().plusDays(30).isBefore(devolucioneDto.getFecha())){
            return false;
        }else{
            //Control de stock
            miCompra.getProducto().setStock(miCompra.getProducto().getStock()+devolucioneDto.getCantidad());
            return true;
        }
    }

    public Compra crearDeDto(CompraDto compraDto){
        Compra compra = new Compra();
        compra.setId(compraDto.getId());
        compra.setCliente(clienteRepository.findById(compraDto.getClienteId()).get());
        compra.setProducto(productoRepository.findById(compraDto.getProductoId()).get());
        compra.setCantidad(compraDto.getCantidad());
        compra.setFecha(compraDto.getFecha());
        return compra;
    }
    public Devolucione crearDeDto(DevolucioneDto devolucioneDto){
        Devolucione devolucione = new Devolucione();
        devolucione.setId(devolucioneDto.getId());
        devolucione.setCliente(clienteRepository.findById(devolucioneDto.getClienteId()).get());
        devolucione.setProducto(productoRepository.findById(devolucioneDto.getProductoId()).get());
        devolucione.setCantidad(devolucioneDto.getCantidad());
        devolucione.setFecha(devolucioneDto.getFecha());
        devolucione.setMotivo(devolucioneDto.getMotivo());
        return devolucione;
    }
    public Producto crearDeDto(ProductoDto productoDto){
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());
        return producto;
    }
    public CompraDto crearCompraDto(Compra compra){
        return new CompraDto(compra.getId(),compra.getCliente().getId(),compra.getProducto().getId(),compra.getFecha(),compra.getImporte(),compra.getCantidad());
    }
    public DevolucioneDto crearDeDto(Devolucione devolucione){
        return new DevolucioneDto(devolucione.getId(),devolucione.getCliente().getId(),devolucione.getProducto().getId(),devolucione.getFecha(),devolucione.getCantidad(),devolucione.getMotivo());
    }
    public ProductoDto crearProductoDto(Producto producto){
        return new ProductoDto(producto.getId(),producto.getNombre(),producto.getDescripcion(),producto.getPrecio(),producto.getStock());
    }
}
