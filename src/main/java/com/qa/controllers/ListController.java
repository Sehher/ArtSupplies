package com.qa.controllers;


import com.qa.models.MyList;
import com.qa.models.Products;
import com.qa.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    ListRepository lr;

    //UpdateProduct
    @RequestMapping(value = "list/{id}", method = RequestMethod.POST)
    public MyList updateProductFromList(@PathVariable Long id){
        MyList list = lr.findOne(id);
        list.setGotIt(true);
        return list;
    }



}
