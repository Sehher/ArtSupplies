package com.qa.service;

import com.qa.models.Products;
import com.qa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> listAllProducts(){
        return productRepository.findAll();
    }

    public Products addProduct(Products products){
        return productRepository.saveAndFlush(products);
    }

    public Products getProducts(Long id) {return productRepository.findOne(id);}

    public Products updateProduct(Long id,Products products){
        Products ex = productRepository.findOne(id);
        ex.setProducts(products);
        return  ex;}

    public Products deleteProduct( Long id){
        Products existing = productRepository.findOne(id);
        productRepository.delete(existing);
        return existing;
    }
}
