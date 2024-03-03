package com.dersler.new_play_sales.Services.abstracts;

import com.dersler.new_play_sales.Entities.Customer;

public interface ICustomerCheckService {

    boolean CheckIfRealPerson(Customer customer) throws Exception;
}
