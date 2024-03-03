package com.dersler.new_play_sales.Services.abstracts;

import com.dersler.new_play_sales.Entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {

    ResponseEntity<String> add(Customer customer) throws Exception;

    List<Customer> getAllCustomer();

    Optional<Customer> getOneCustomer(int Id);

    ResponseEntity<String> updateCustomer(int Id, Customer customer) throws Exception;

    void deleteCustomer(int customerId);


}
