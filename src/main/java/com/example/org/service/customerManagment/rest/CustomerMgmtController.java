package com.example.org.service.customerManagment.rest;

import com.example.org.service.customerManagment.dao.CustomerMgmtRepo;
import com.example.org.service.customerManagment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerMgmtController {

    @Autowired
    CustomerMgmtRepo repo;


    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable int id){
        System.out.println("Extracting id: "+id);
        repo.getCustomer();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
