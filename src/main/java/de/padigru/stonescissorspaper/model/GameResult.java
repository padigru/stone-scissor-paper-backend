package de.padigru.stonescissorspaper.model;

/**
 * Contains the winner, the decision from player and the decision from computer
 *
 * @author padigru
 */
public class GameResult {

    private Choice playerChoice;
    private Choice computerChoice;
    private Winner winner;

    public GameResult(Choice playerChoice, Choice computerChoice) {
        this.playerChoice = playerChoice;
        this. computerChoice = computerChoice;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public Choice getPlayerChoice() {
        return playerChoice;
    }

    public Choice getComputerChoice() {
        return computerChoice;
    }

    public Winner getWinner() {
        return winner;
    }
}
