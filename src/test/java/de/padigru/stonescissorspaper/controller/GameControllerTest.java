package de.padigru.stonescissorspaper.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPlayGame() throws Exception {
        ResultActions result = mockMvc.perform(post("/api/v1/play").contentType(MediaType.APPLICATION_JSON)
                        .param("playerChoice", "STONE"))
                .andExpect(status().isOk());

        result.andExpect(jsonPath("$.playerChoice", equalTo("STONE")));
        result.andExpect(jsonPath("$.winner", anyOf(equalTo("COMPUTER"), equalTo("PLAYER"), equalTo("DRAW"))));
        result.andExpect(jsonPath("$.computerChoice", anyOf(equalTo("PAPER"), equalTo("SCISSOR"), equalTo("STONE"))));
    }

    @Test
    public void testWrongInputForPlayerChoice() throws Exception {
        mockMvc.perform(post("/api/v1/play").contentType(MediaType.APPLICATION_JSON)
                        .param("playerChoice", "SPOCK"))
                .andExpect(status().isBadRequest());
    }

}
