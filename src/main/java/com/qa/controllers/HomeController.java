package com.qa.controllers;

import com.qa.models.Products;
import com.qa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "helloWorld";
    }

}
