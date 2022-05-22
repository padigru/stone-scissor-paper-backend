package de.padigru.stonescissorspaper.service.impl;

import de.padigru.stonescissorspaper.model.Choice;
import de.padigru.stonescissorspaper.model.Game;
import de.padigru.stonescissorspaper.model.GameResult;
import de.padigru.stonescissorspaper.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public GameResult play(Choice playerChoice) {
        Game game = new Game(playerChoice);
        return game.play();
    }

}
