package com.dersler.new_play_sales.Services.abstracts;


import com.dersler.new_play_sales.Entities.Sales;
import com.dersler.new_play_sales.request.SalesCreateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISalesService {

    ResponseEntity<String> add(SalesCreateRequest salesCreateRequest) throws Exception;

    List<Sales> getAllSale();

    Optional<Sales> getOneSale(int Id);

    ResponseEntity<String> updateSale(int Id, Sales sales) throws Exception;

    void deleteSale(int Id);

}
