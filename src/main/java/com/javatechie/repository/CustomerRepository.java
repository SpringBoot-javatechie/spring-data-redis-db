package com.javatechie.repository;

import com.javatechie.hash.Customer;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
