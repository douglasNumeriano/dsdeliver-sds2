package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

// Essa  classe será um componente que pode ser injetado no controllador
@Service
public class OrderService {
    // Esta anotação faz a instancia de um objeto ProductRepository
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    //Especifica que é uma transação somente de leitura, assim fica mais rápida
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrderWithProducts();

        //Para cada objeto da lista de Produtos transformamos em objeto DTO
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    //Inserindo um pedido
    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for(ProductDTO p : dto.getProducts()){
            //Este método getOne vai permitir o salvamento da associação dos produtos ao pedido
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }

        //Salva o objeto no banco
        order = repository.save(order);

        return new OrderDTO(order);
    }

    //Alterar status de um pedido
    @Transactional
    public OrderDTO setDelivere(Long id){
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
