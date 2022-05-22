package de.padigru.stonescissorspaper.model;

import java.util.Random;

/**
 * This class contains the game logic.
 *
 * @author padigru
 */
public class Game {

    private final Choice playerChoice;

    public Game(Choice playerChoice) {
        this.playerChoice = playerChoice;
    }

    /**
     * Choose random a computer decision and decide who win.
     *
     * @return the winner, the decision from player and the decision from computer
     */
    public GameResult play() {
        Random rand = new Random();
        Choice comChoice = Choice.values()[rand.nextInt(Choice.values().length)];

        GameResult result = new GameResult(playerChoice, comChoice);

        if (comChoice.equals(playerChoice)) {
            result.setWinner(Winner.DRAW);
        } else if (didThePlayerWin(comChoice)) {
            result.setWinner(Winner.PLAYER);
        } else {
            result.setWinner(Winner.COMPUTER);
        }

        return result;
    }

    /**
     * Did the Player win?
     *
     * @param c choice from player
     * @return true if player wins, false if computer wins
     */
    private boolean didThePlayerWin(Choice c) {
        if (Choice.STONE.equals(playerChoice) && Choice.SCISSORS.equals(c) ||
                Choice.SCISSORS.equals(playerChoice) && Choice.PAPER.equals(c) ||
                Choice.PAPER.equals(playerChoice) && Choice.STONE.equals(c)) {

            return true;
        }
        return false;
    }

}
