package com.qa.controller;


import com.qa.controllers.HomeController;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private ProductRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public void testGetAllProducts(){
        List<Products> productList = new ArrayList<>();
        Products product = new Products();
        product.setDescription("blah");
        product.setName("blah");
        productList.add(product);

        when(repository.findAll()).thenReturn(productList); //if you need a test that needs to return something from the repo, use this test
        //HomeController.listProducts();
        assertEquals(homeController.listAllProducts().get(0).getName(),"blah");
    }

    @Test
    public void testGetOneProduct(){
        Products product = new Products();
        product.setName("blah");
        when(repository.findOne(1L)).thenReturn(product);
        homeController.getProduct(1L);//1L means 1 Long
    }

    @Test
    public void testAddNote(){
        Products product = new Products();
        product.setName("blah");
        product.setDescription("blah blah");
        when(repository.saveAndFlush(product)).thenReturn(product);
        homeController.addProduct(product);
    }

    @Test
    public void testDeleteNote(){
        Products product = new Products();
        product.setName("blah");
        when(repository.findOne(1L)).thenReturn(product);
        homeController.deleteProductFromList(1L);
    }

}
