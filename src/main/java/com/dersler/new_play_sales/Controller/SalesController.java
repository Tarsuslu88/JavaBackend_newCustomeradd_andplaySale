package com.dersler.new_play_sales.Controller;

import com.dersler.new_play_sales.Entities.Sales;
import com.dersler.new_play_sales.Services.abstracts.ISalesService;
import com.dersler.new_play_sales.request.SalesCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/sales")
public class SalesController {

    private final ISalesService salesService;

    public SalesController(ISalesService salesService) {
        this.salesService = salesService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody SalesCreateRequest salesCreateRequest) throws Exception{
        return salesService.add(salesCreateRequest);

    }

    @GetMapping("/all")
    public List<Sales> getAllSale(){
        return salesService.getAllSale();
    }

    @GetMapping("/{Id}")
    Optional<Sales> getOneSale(@PathVariable int Id){
        return salesService.getOneSale(Id);
    }

    @PutMapping("/{Id}")
    ResponseEntity<String> updateSale(@PathVariable int Id, @RequestBody Sales sales) throws Exception{
        return salesService.updateSale(Id, sales);
    }

    @DeleteMapping("/{Id}")
    void deleteSale(@PathVariable int Id){
        salesService.deleteSale(Id);
    }


}
