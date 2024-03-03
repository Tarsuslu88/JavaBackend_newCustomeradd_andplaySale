package com.dersler.new_play_sales.Services.concrete;

import com.dersler.new_play_sales.Entities.Customer;
import com.dersler.new_play_sales.Entities.Games;
import com.dersler.new_play_sales.Repository.GameRepository;
import com.dersler.new_play_sales.Services.abstracts.IGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameManager implements IGameService {

    private final GameRepository gameRepository;

    public GameManager(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public ResponseEntity<String> add(Games games) throws Exception {
        Optional<Games> game1 = gameRepository.findByGameName(games.getGameName());
        try {
            if(game1.isEmpty()){
                Games game = new Games();
                game.setGameName(games.getGameName());
                game.setFirstQuantity(games.getFirstQuantity());
                game.setSoldQuantity(games.getSoldQuantity());
                game.setLastQuantity(games.getFirstQuantity() - games.getSoldQuantity());
                gameRepository.save(game);
                return ResponseEntity.ok("Oyun başarılı bir şekilde kaydedildi.");
            }else{
                return ResponseEntity.badRequest().body("Bu oyun daha önceden kayıt edilmiştir!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Games> getAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Games> getOneGame(int Id) {
        return gameRepository.findById(Id);
    }

    @Override
    public ResponseEntity<String> updateGame(int Id, Games games) throws Exception {
        Optional<Games> game1 = gameRepository.findById(Id);
        if(game1.isPresent()){
            Games forUpdateGame = game1.get();
            if(games.getGameName() != forUpdateGame.getGameName() && games.getGameName().length()>0)
                forUpdateGame.setGameName(games.getGameName());
            if(games.getFirstQuantity() != forUpdateGame.getFirstQuantity())
                forUpdateGame.setFirstQuantity(games.getFirstQuantity());
            if(games.getSoldQuantity() != forUpdateGame.getSoldQuantity()){
                forUpdateGame.setSoldQuantity(games.getSoldQuantity());
                int total = (forUpdateGame.getFirstQuantity() - games.getSoldQuantity());
                forUpdateGame.setLastQuantity(total);
            }
            gameRepository.save(forUpdateGame);
            return ResponseEntity.ok("oyuna ait bilgiler güncellenmiştir.");
        }else{
            return ResponseEntity.badRequest().body("bilgilerini güncellemeye çalıştığınız oyun sistemimizde mevcut değildir!");
        }
    }

    @Override
    public void deleteGame(int Id) {
        gameRepository.deleteById(Id);
    }
}
