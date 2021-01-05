package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// Essa  classe será um componente que pode ser injetado no controllador
@Service
public class ProductService {
    // Esta anotação faz a instancia de um objeto ProductRepository
    @Autowired
    private ProductRepository repository;

    //Especifica que é uma transação somente de leitura, assim fica mais rápida
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> list = repository.findAllByOrderByNameAsc();

        //Para cada objeto da lista de Produtos transformamos em objeto DTO
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
