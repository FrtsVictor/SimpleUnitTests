package com.restapi.demo.repository;

import com.restapi.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Long> {
}
