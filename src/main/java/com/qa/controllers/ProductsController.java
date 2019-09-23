package com.qa.controllers;

import com.qa.models.Products;
import com.qa.repository.ProductRepository;
import com.qa.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Products> listAllProducts(){
        return productsService.listAllProducts();
    }

    @RequestMapping(value = "products",method = RequestMethod.POST)
    public Products addNote(@RequestBody Products products){
        return productsService.addProduct(products);
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    public Products getProducts(@PathVariable Long id){
        return productsService.getProducts(id);
    }

    @Transactional
    @RequestMapping(value = "products/{id}", method = RequestMethod.PUT)
    public Products updateProducts(@PathVariable Long id, @RequestBody Products products){
        return productsService.updateProduct(id, products);
    }


    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public Products deleteProductFromList(@PathVariable Long id){
       return productsService.deleteProduct(id);
    }
}
