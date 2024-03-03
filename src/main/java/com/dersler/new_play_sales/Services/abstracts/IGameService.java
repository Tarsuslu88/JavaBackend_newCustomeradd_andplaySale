package com.dersler.new_play_sales.Services.abstracts;

import com.dersler.new_play_sales.Entities.Games;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IGameService {

    ResponseEntity<String> add(Games games) throws Exception;

    List<Games> getAllGame();

    Optional<Games> getOneGame(int Id);

    ResponseEntity<String> updateGame(int Id, Games games) throws Exception;

    void deleteGame(int Id);
}
