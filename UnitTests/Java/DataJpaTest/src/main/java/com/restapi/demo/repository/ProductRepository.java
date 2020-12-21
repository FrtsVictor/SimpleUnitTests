package com.restapi.demo.repository;

import com.restapi.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT * FROM products pdt WHERE pdt.id = ?1",
            nativeQuery = true)
    Product productById(Long id);

    Product findByName(String name);



}
