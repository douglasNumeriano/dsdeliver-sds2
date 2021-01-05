package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA Repository: É uma interface que faz parte do Framework Spring Data JPA, ela ja traz alguns métodos para funções de CRUD
//Desta forma consguimos fazer consultas operações de crud relacionadana a classe "Product"
public interface OrderRepository extends JpaRepository<Order, Long> {
}
