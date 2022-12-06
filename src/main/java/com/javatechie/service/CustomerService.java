package com.javatechie.service;

import com.javatechie.hash.Customer;
import com.javatechie.repository.CustomerDAO;
import com.javatechie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO dao;

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        //return dao.addCustomer(customer);
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        //return dao.getAllCustomers();
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Customer getCustomer(int id) {
        //return dao.getCustomer(id);
        return repository.findById(id).get();
    }

    public String deleteCustomer(int id) {
        //return dao.deleteCustomer(id);
        repository.deleteById(id);
        return "customer removed !";
    }

    public Customer updateCustomer(int id, Customer customer) {
        //return dao.updateCustomer(id, customer);
        Customer existingCustomer = repository.findById(id).get();
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setDob(customer.getDob());
        return repository.save(existingCustomer);

    }
}
