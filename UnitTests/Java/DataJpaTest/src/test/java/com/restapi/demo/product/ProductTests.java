package com.restapi.demo.product;

import com.restapi.demo.model.Product;
import com.restapi.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // will use the H2 Tabase by default
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //now i'll don't replace the database
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct(){
        Product product = new Product("iphone 10", 584);
        Product savedProduct = productRepository.save(product);

        assertNotNull(savedProduct);

    }

}
