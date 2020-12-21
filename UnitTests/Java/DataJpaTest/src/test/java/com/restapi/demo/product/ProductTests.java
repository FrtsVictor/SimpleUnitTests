package com.restapi.demo.product;

import com.restapi.demo.model.Product;
import com.restapi.demo.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest // will use the H2 Tabase by default
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //now i'll don't replace the database, and use postgres
public class ProductTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateProduct() {
        Product product = new Product("iphone 10", 584);
        Product savedProduct = productRepository.save(product);

        assertNotNull(savedProduct);
    }

    @Test
    @Order(2)
    public void testFindProductByIdExists() {
        Long id = 1l;
        Product product = productRepository.productById(id);

        assertEquals(product.getId(), id);
    }

    @Test
    @Order(3)
    public void testFindProductByIdNotExists() {
        Long id = 0l;
        Product product = productRepository.productById(id);

        assertNull(product);
    }


    @Test
    @Order(4)
    public void testFindProductByNameExists() {
        String name = "iphone 10";
        Product product = productRepository.findByName(name);

        Assertions.assertThat(product.getName()).isEqualTo(name);
    }

    @Test
    @Order(5)
    public void testFindProductByNameNotExists() {
        String name = "notExists";
        Product product = productRepository.findByName(name);

        assertNull(product);
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void testUpdateProduct() {
        String productName = "New Updated Product";
        Product product = new Product(productName, 500);

        productRepository.save(product);

        Product updatedProduct = productRepository.findByName(productName);

        Assertions.assertThat(updatedProduct.getName()).isEqualTo(productName);
    }

    @Test
    @Order(7)
    public void testUpdateProductNotUpdated() {
        String productName = "New Updated Product";
        String newProductName = "New Updated Product2";
        float newProductPrice = 10;

        Product updatedProduct = productRepository.findByName(productName);
        updatedProduct.setPrice(newProductPrice);
        updatedProduct.setName(newProductName);

        productRepository.save(updatedProduct);

        Product updatedProductSaved = productRepository.findByName(newProductName);

        Assertions.assertThat(updatedProductSaved.getName()).isEqualTo(newProductName);
    }

    @Test
    @Order(8)
    public void testGetAll() {
        List<Product> products = (List<Product>) productRepository.findAll();

        for (Product product : products) {
            System.out.println(product);
        }

        Assertions.assertThat(products).size().isGreaterThan(0);
    }


    @Test
    @Order(9)
    public void testDeleteProduct() {
        Long id = 1l;

        Boolean existsBeforeDelete = productRepository.existsById(id);
        productRepository.deleteById(id);

        Boolean existsAfterDelete = productRepository.existsById(id);

        assertTrue(existsBeforeDelete);
        assertFalse(existsAfterDelete);

    }


}