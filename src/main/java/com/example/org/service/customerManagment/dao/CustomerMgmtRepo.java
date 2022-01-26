package com.example.org.service.customerManagment.dao;


import com.example.org.service.customerManagment.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CustomerMgmtRepo {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${select.customer.details}")
    String selectCustomer;

    @Value("${insert.customer.details}")
    String insertCustomerDetails;

    public Customer getCustomer(){
        System.out.println("query: "+selectCustomer);
        List<Map<String,Object>> rs=jdbcTemplate.queryForList(selectCustomer,new HashMap<>()) ;
        rs.stream().forEach(x->{
            System.out.println("Id: "+x.get("id"));
            System.out.println("Name: "+x.get("name"));
            System.out.println("Age: "+x.get("age"));
        });
        return  null;
    }


    public Customer addCustomer(Customer inputCustomer){

        Map<String,Object> passingMap=new HashMap<String,Object>();
        passingMap.put("name",inputCustomer.getName());
        passingMap.put("id",inputCustomer.getId());
        passingMap.put("age",inputCustomer.getAge());
        jdbcTemplate.update(insertCustomerDetails,passingMap);
        return inputCustomer;
    }

}
