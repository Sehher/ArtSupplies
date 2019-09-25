package com.qa.controller;

import com.qa.controllers.HomeController;
import com.qa.controllers.ProductsController;
import com.qa.models.Products;
import com.qa.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ProductsControllerTest {

    @InjectMocks
    private ProductsController productsController;

    @Mock
    private ProductRepository productRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllProducts() {
        List<Products> productsList = new ArrayList<>();
        Products product = new Products();
        product.setDescription("Slow drying paint");
        product.setName("oil paint");
        product.setCategory("paint");
        product.setImageUrl("www.paint.com");
        productsList.add(product);

        when(productRepository.findAll()).thenReturn(productsList); //if you need a test that needs to return something from the repo, use this test

        assertEquals(productsController.listAllProducts().get(0).getName(), "oil paint");
    }

    @Test
    public void testGetProduct() {
        Products products = new Products();
        products.setDescription("Slow drying paint");
        products.setName("oil paint");
        products.setCategory("paint");
        products.setImageUrl("www.paint.com");
        products.setId(1l);
        when(productRepository.findOne(1l)).thenReturn(products);
        assertEquals(productsController.getProducts(1L).getName(),"oil paint");
    }

    @Test
    public void testAddProduct() {
        Products products = new Products();
        products.setDescription("Slow drying paint");
        products.setName("oil paint");
        products.setCategory("paint");
        products.setImageUrl("www.paint.com");
        when(productRepository.saveAndFlush(products)).thenReturn(products);
        assertEquals(productsController.addProducts(products).getName(),"blah");
    }

    @Test
    public void testDeleteProducts() {
        Products products = new Products();
        products.setDescription("Slow drying paint");
        products.setName("oil paint");
        products.setCategory("paint");
        products.setImageUrl("www.paint.com");
        when(productRepository.findOne(1L)).thenReturn(products);
        assertEquals(productsController.deleteProductFromList(1L),products);
    }
}

