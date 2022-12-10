package com.javatechie.service;

import com.javatechie.hash.Customer;
import com.javatechie.repository.CustomerDAO;
import com.javatechie.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerDAO dao;

    private static final String CACHE_NAME="customers";

    @Autowired
    private CustomerRepository repository;

    @CachePut(key = "#customer.id",value = CACHE_NAME)
    public Customer saveCustomer(Customer customer) {
        //return dao.addCustomer(customer);
        log.info("CustomerService::saveCustomer() Inserting record to DB");
        return repository.save(customer);
    }

    @Cacheable(value = CACHE_NAME)
    public List<Customer> getAllCustomers() {
        //return dao.getAllCustomers();
        log.info("CustomerService::getAllCustomers() fetching records from DB");
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Cacheable(key = "#id",value = CACHE_NAME)
    public Customer getCustomer(int id) {
        //return dao.getCustomer(id);
        log.info("CustomerService::getCustomer() fetching record from DB");
        return repository.findById(id).get();
    }

    @CacheEvict(key = "#id",value = CACHE_NAME)
    public String deleteCustomer(int id) {
        //return dao.deleteCustomer(id);
        log.info("CustomerService::deleteCustomer() deleting record from DB");
        repository.deleteById(id);
        return "customer removed !";
    }

    @CachePut(key = "#id",value = CACHE_NAME)
    public Customer updateCustomer(int id, Customer customer) {
        //return dao.updateCustomer(id, customer);
        log.info("CustomerService::updateCustomer() updating record from DB");
        Customer existingCustomer = repository.findById(id).get();
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setDob(customer.getDob());
        return repository.save(existingCustomer);

    }
}
