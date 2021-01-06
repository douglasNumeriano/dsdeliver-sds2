package com.devsuperior.dsdeliver.controllers;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.services.OrderService;
import com.devsuperior.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//Caminho do seu recurso
@RequestMapping(value = "/orders")
public class OrderController {

    //Dependencia para o service
    @Autowired
    private OrderService service;

    //Resposta do Tipo GET do http
    //ResponseEntity: é o tipo de resposta do método encapsulada
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){

        List<OrderDTO> list = service.findAll();
        //Este "ok()" retorna o código 200 http que quer dizer sucesso
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
