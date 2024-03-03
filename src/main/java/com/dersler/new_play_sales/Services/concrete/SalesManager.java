package com.dersler.new_play_sales.Services.concrete;

import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Entities.Games;
import com.dersler.new_play_sales.Entities.Sales;
import com.dersler.new_play_sales.Repository.SalesRepository;
import com.dersler.new_play_sales.Services.abstracts.ISalesService;
import com.dersler.new_play_sales.request.SalesCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesManager implements ISalesService {

    private final SalesRepository salesRepository;
    private final CustomerManager customerManager;
    private final GameManager gameManager;

    public SalesManager(SalesRepository salesRepository, CustomerManager customerManager, GameManager gameManager) {
        this.salesRepository = salesRepository;
        this.customerManager = customerManager;
        this.gameManager = gameManager;
    }

    @Override
    public ResponseEntity<String> add(SalesCreateRequest salesCreateRequest) throws Exception {

        Optional<Customer> customer = customerManager.getOneCustomer(salesCreateRequest.getCustomerId());
        Optional<Games> games = gameManager.getOneGame(salesCreateRequest.getGameId());

        if(customer == null && games == null)
            return ResponseEntity.badRequest().body("Satın almak için giriş yaptığınız kullanıcı geçersiz ya da satın almaya çalıştığınız oyun bulunmamaktadır !!");
        Sales toSave = new Sales();
        toSave.setCustomer(customer.get());
        toSave.setGames(games.get());
        toSave.setSalesQuantity(salesCreateRequest.getSalesQuantity());
        toSave.setSalesGameName(games.get().getGameName());
        games.get().setSoldQuantity(salesCreateRequest.getSalesQuantity());
        games.get().setLastQuantity(games.get().getFirstQuantity() - games.get().getSoldQuantity());
        salesRepository.save(toSave);
        gameManager.updateGame(games.get().getId(), games.get());
        if ((salesRepository.save(toSave)) != null) {
            return ResponseEntity.ok("ürün satışı başarılı bir şekilde yapılmıştır");
        }else{
            return ResponseEntity.badRequest().body("Satış işlemi sırasında beklenmedik bir sorun ile karşılaşılmıştır. Lütfen daha sonra tekrar deneyiniz !");
        }
    }

    @Override
    public List<Sales> getAllSale() {
        return salesRepository.findAll();
    }

    @Override
    public Optional<Sales> getOneSale(int Id) {
        return salesRepository.findById(Id);
    }

    @Override
    public ResponseEntity<String> updateSale(int Id, Sales sales) throws Exception {
        Optional<Sales> SalesDb = salesRepository.findById(Id);
        if(SalesDb.isPresent()){
            Sales toUpdateSale = SalesDb.get();
            if(sales.getSalesQuantity() != toUpdateSale.getSalesQuantity())
                toUpdateSale.setSalesQuantity(sales.getSalesQuantity());
            if(sales.getCustomer().getId() != toUpdateSale.getCustomer().getId())
                toUpdateSale.getCustomer().setId(sales.getCustomer().getId());
            if(sales.getGames().getId() != toUpdateSale.getGames().getId())
                toUpdateSale.getGames().setId(sales.getGames().getId());

            salesRepository.save(toUpdateSale);
            return ResponseEntity.ok("Satışa ait bilgiler başarılı bir şekilde güncellenmiştir.");
        }else{
            return ResponseEntity.badRequest().body("belirtilen satışa ait herhangi bir kayıt bulunamamıştır!");
        }
    }

    @Override
    public void deleteSale(int Id) {
        salesRepository.deleteById(Id);
    }
}
