package org.example.tennisgamekata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TennisGameTest {

    private final TennisGame tennisGame = new TennisGame();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @ParameterizedTest
    @CsvSource({
            "AA,Player A :15 / Player B :0 Player A :30 / Player B :0",

            "AABB,  Player A :15 / Player B :0 " +
                    "Player A :30 / Player B :0 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30",

            "ABABAB,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30 " +
                    "Player A :40 / Player B :30 " +
                    "Deuce Game",

            "ABABBAA,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30 " +
                    "Player A :30 / Player B :40 " +
                    "Deuce Game " +
                    "Advantage A",

            "ABABBAABB,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30 " +
                    "Player A :30 / Player B :40 " +
                    "Deuce Game " +
                    "Advantage A " +
                    "Deuce Game " +
                    "Advantage B",


            "ABABAA,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30 " +
                    "Player A :40 / Player B :30 " +
                    "Player A wins the game",

            "ABABBB,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :30 / Player B :15 " +
                    "Player A :30 / Player B :30 " +
                    "Player A :30 / Player B :40 " +
                    "Player B wins the game",

            "ABB,Player A :15 / Player B :0 " +
                    "Player A :15 / Player B :15 " +
                    "Player A :15 / Player B :30 ",

            "BBBBA,Player A :0 / Player B :15 " +
                    "Player A :0 / Player B :30 " +
                    "Player A :0 / Player B :40 " +
                    "Player B wins the game ",

            "A,Player A :15 / Player B :0 ",
    }
    )
    public void shouldPrintScore(String resultGame, String expectedScore) {

        tennisGame.getScore(resultGame);

        Assertions.assertEquals(expectedScore, outputStreamCaptor.toString().trim().replace("\n", " "));

    }

    @Test
    public void shouldThrowExceptionWhenResultNull() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                tennisGame.getScore(""));
        Assertions.assertEquals("Illegal result", exception.getMessage());
    }
}
