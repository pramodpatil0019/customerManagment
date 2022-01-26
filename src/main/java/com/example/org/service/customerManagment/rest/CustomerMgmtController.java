package com.example.org.service.customerManagment.rest;

import com.example.org.service.customerManagment.dao.CustomerMgmtRepo;
import com.example.org.service.customerManagment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Map<String,Object> input){
        Customer cust=new Customer((String)input.get("name"),(int)input.get("id"),(int)input.get("age"));
        return new ResponseEntity<>(repo.addCustomer(cust),HttpStatus.OK);

    }
}
