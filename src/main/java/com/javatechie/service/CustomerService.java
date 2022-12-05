package com.javatechie.service;

import com.javatechie.hash.Customer;
import com.javatechie.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO dao;

    public Customer saveCustomer(Customer customer){
        return dao.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public Customer getCustomer(int id) {
        return dao.getCustomer(id);
    }

    public String deleteCustomer(int id) {
        return dao.deleteCustomer(id);
    }

    public Customer updateCustomer(int id, Customer customer) {
        return dao.updateCustomer(id, customer);
    }
}
