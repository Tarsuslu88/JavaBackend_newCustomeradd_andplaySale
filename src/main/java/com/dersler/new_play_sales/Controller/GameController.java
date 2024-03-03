package com.dersler.new_play_sales.Controller;

import com.dersler.new_play_sales.Entities.Games;
import com.dersler.new_play_sales.Services.abstracts.IGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    private final IGameService gameService;

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Games games) throws Exception{
        return gameService.add(games);
    }


    @GetMapping("/all")
    public List<Games> getAllGame(){
        return  gameService.getAllGame();
    }

    @GetMapping("/{Id}")
    public Optional<Games> getOneGame(@PathVariable int Id){
        return gameService.getOneGame(Id);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<String> updateGame(@PathVariable int Id, @RequestBody Games games) throws Exception {
        return gameService.updateGame(Id, games);
    }

    @DeleteMapping("/{Id}")
    public void deleteGame(@PathVariable int Id){
        gameService.deleteGame(Id);

    }


}
