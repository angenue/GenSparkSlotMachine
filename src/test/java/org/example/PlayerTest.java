package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testCheckForSufficientCoins() {
        Player player = new Player();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        player.setAmountOfCash(3);
        assertThrows(Player.InsufficientFundsException.class, player::checkForSufficientCoins);

        assertTrue(outputStream.toString().contains("Insufficient funds. You need more than 5 coins to play"));

        System.setOut(System.out);
    }

}