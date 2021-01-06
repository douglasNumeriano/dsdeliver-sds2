package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Essa  classe será um componente que pode ser injetado no controllador
@Service
public class OrderService {
    // Esta anotação faz a instancia de um objeto ProductRepository
    @Autowired
    private OrderRepository repository;

    //Especifica que é uma transação somente de leitura, assim fica mais rápida
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrderWithProducts();

        //Para cada objeto da lista de Produtos transformamos em objeto DTO
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
