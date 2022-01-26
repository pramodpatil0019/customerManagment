package com.example.org.service.customerManagment.dao;


import com.example.org.service.customerManagment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CustomerMgmtRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${select.customer.details}")
    String selectCustomer;

    public Customer getCustomer(){
        System.out.println("query: "+selectCustomer);
        List<Map<String,Object>> rs=jdbcTemplate.queryForList(selectCustomer);
        rs.stream().forEach(x->{
            System.out.println("Id: "+x.get("id"));
            System.out.println("Name: "+x.get("name"));
            System.out.println("Age: "+x.get("age"));
        });
        return  null;
    }
}
