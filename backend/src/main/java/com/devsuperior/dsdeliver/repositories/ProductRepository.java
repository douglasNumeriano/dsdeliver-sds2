package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JPA Repository: É uma interface que faz parte do Framework Spring Data JPA, ela ja traz alguns métodos para funções de CRUD
//Desta forma consguimos fazer consultas operações de crud relacionadana a classe "Product"
public interface ProductRepository extends JpaRepository<Product, Long> {
    // A assinatura deste método ira ordenar uma consulta pelo campo nome
    List<Product> findAllByOrderByNameAsc();
}
