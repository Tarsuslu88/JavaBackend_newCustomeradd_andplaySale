package com.dersler.new_play_sales.Repository;

import com.dersler.new_play_sales.Entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
