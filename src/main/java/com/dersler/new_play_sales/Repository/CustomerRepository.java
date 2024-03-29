package com.dersler.new_play_sales.Repository;

import com.dersler.new_play_sales.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByUserName(String userName);

    Optional<Customer> findByNationalityId(String nationalityId);

   //Optional<Customer> findByUserNameOrNationalityId(String userName, String nationalityId);


}
