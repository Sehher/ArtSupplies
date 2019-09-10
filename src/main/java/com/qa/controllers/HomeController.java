package com.qa.controllers;

import com.qa.models.Products;
import com.qa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class HomeController {

    @Autowired
    ProductRepository pr;

    @RequestMapping("/")
    public String home(){
        return "Index";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public List<Products> listAllProducts(){
        return pr.findAll();
    }

    @RequestMapping(value = "products",method = RequestMethod.POST)
    public Products addProduct(@RequestBody Products products){
            return pr.saveAndFlush(products);
    }

//    @RequestMapping(value = "notes/{id}",method = RequestMethod.GET)
//    public Products getProduct(@PathVariable Long id){
//        return ProductRepository.findOne(id);
//    }

    //DeleteProduct
    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public Products deleteProductFromList(@PathVariable Long id){
        Products existing = pr.findOne(id);
        pr.delete(existing);
        return existing;
    }








}
