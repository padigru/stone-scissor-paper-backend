package de.padigru.stonescissorspaper.controller;

import de.padigru.stonescissorspaper.model.Choice;
import de.padigru.stonescissorspaper.model.GameResult;
import de.padigru.stonescissorspaper.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This class serve an endpoint to start the game.
 *
 * @author padigru
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin()
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     *
     * @param playerChoice decision from player (stone, scissor or paper)
     * @return the winner, the decision from player and the decision from computer
     */
    @PostMapping("/play")
    public GameResult playGame(@Valid @RequestParam Choice playerChoice) {
        return gameService.play(playerChoice);
    }

}
