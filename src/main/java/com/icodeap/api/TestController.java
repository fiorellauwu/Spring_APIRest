package com.icodeap.api;

import com.icodeap.api.model.Producto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/hello")
    public String hello(){

        return "Hello Spring";
    }
    @GetMapping("/bye")
    public String bye(){

        return "Bye Spring";
    }
    @GetMapping("/producto")
    public Producto get(){

        return new Producto(1,"Televisor","Televisor de 21 pulgadas",560.3D);
    }

    @GetMapping("/productos")
    public List<Producto> getProducts(){
           return getProductos();
    }
    @GetMapping("/productos/{id}")
    public Producto getProduct(@PathVariable Integer id){
        for (Producto p:  getProductos() )  {
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    @PostMapping("/productos")
    public String receivProduct(@RequestBody Producto producto){
        log.info("ID de producto {}",producto.getId());
        return "Producto recibido";
    }

    public List<Producto> getProductos(){
        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto(1,"Televisor","Televisor de 21 pulgadas",560.3D));
        listaProductos.add(new Producto(2,"Monitor","Monitor de 21 pulgadas",160D));
        listaProductos.add(new Producto(3,"Computador","Procesador I/",720D));
        listaProductos.add(new Producto(4,"Refrigerador","Refrigerador de 12 pies",800D));
        listaProductos.add(new Producto(5,"Escritorio","Escritorio 120X100",12D));
        listaProductos.add(new Producto(6,"Mesa","Mesa de escritorio",80D));

        return listaProductos;
    }

}
