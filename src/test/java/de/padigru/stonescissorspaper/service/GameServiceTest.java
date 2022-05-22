package de.padigru.stonescissorspaper.service;

import de.padigru.stonescissorspaper.model.Choice;
import de.padigru.stonescissorspaper.model.GameResult;
import de.padigru.stonescissorspaper.model.Winner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Test
    public void test() {
        GameResult gameResult = gameService.play(Choice.STONE);

        if (gameResult.getWinner().equals(Winner.COMPUTER)) {
            assertThat(gameResult.getComputerChoice(), equalTo(Choice.PAPER));
        } else if (gameResult.getWinner().equals(Winner.PLAYER)) {
            assertThat(gameResult.getComputerChoice(), equalTo(Choice.SCISSORS));
        } else {
            assertThat(gameResult.getComputerChoice(), equalTo(Choice.STONE));
        }

    }

}
