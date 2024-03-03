package com.dersler.new_play_sales.Repository;

import com.dersler.new_play_sales.Entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Games, Integer> {
    Optional<Games> findByGameName(String name);
}
