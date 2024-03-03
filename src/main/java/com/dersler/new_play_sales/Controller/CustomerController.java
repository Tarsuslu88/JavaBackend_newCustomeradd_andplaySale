package com.dersler.new_play_sales.Controller;

import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Repository.CustomerRepository;
import com.dersler.new_play_sales.Services.abstracts.ICustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Customer customer) throws Exception {
        return customerService.add(customer);

    }

    @GetMapping("/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{Id}")
    public Optional<Customer> getOneCustomer(@PathVariable int Id){
        return customerService.getOneCustomer(Id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int Id, @RequestBody Customer customer) throws Exception {
        return customerService.updateCustomer(Id,customer);
    }

    @DeleteMapping("/{Id}")
    public void deleteCustomer(@PathVariable int Id){
        customerService.deleteCustomer(Id);
    }


}
