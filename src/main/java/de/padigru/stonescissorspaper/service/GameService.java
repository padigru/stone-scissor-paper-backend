package de.padigru.stonescissorspaper.service;

import de.padigru.stonescissorspaper.model.Choice;
import de.padigru.stonescissorspaper.model.GameResult;

public interface GameService {

    GameResult play(Choice playerChoice);

}
