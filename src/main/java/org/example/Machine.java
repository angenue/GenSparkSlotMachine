package org.example;

import java.util.Arrays;
import java.util.Random;

public class Machine {
    private final Symbol[] SYMBOLS = Symbol.values();
    private Player player = new Player();
    private Random random = new Random();

    public Machine() {
    }

    public void spinWheel() throws Player.InsufficientFundsException {
        player.checkForSufficientCoins();

        System.out.println("Spinning wheel...");

        // Every time player spins, it costs 5 coins
        player.setAmountOfCash(player.getAmountOfCash() - 5);
        System.out.println();
        System.out.println("Coins: " + player.getAmountOfCash());

        // Generate array with random symbols
        Symbol[] result = generateRandomSymbols();
        System.out.println();
        System.out.println("Symbols: " + Arrays.toString(result)); // Print out the generated symbols

        System.out.println();
        System.out.println(winningCombinations(result));
    }

    private Symbol[] generateRandomSymbols() {
        Symbol[] result = new Symbol[3];
        for(int i = 0; i < 3; i++) {
            result[i] = SYMBOLS[random.nextInt(SYMBOLS.length)];
        }
        return result;
    }


    private String winningCombinations(Symbol[] symbols) {
        //if three of the same fruit then you win
        //if one or more sevens you win
        int sevenCount = 0;
        int watermelonCount = 0;
        int orangeCount = 0;
        int grapeCount = 0;
        int cherryCount = 0;
        int bananaCount = 0;
        int coinsWon  = 0;

        for (Symbol symbol : symbols) {
            switch (symbol) {
                case GRAPE -> grapeCount += 1;
                case SEVEN -> sevenCount += 1;
                case BANANA -> bananaCount += 1;
                case CHERRY -> cherryCount += 1;
                case ORANGE -> orangeCount += 1;
                case WATERMELON -> watermelonCount += 1;
            }
        }

        String winningLine;

        if(sevenCount == 3) {
            winningLine = "JACKPOT!! You win 30 coins";
            coinsWon = 30;
        } else if (sevenCount == 2) {
            winningLine ="Congrats, you got two 7's. You won 4 coins.";
            coinsWon = 4;
        }
        else if (sevenCount == 1) {
            winningLine="You got one 7. You won 1 coin.";
            coinsWon = 1;
        }else if(watermelonCount == 3 || orangeCount == 3 || grapeCount == 3 || cherryCount == 3 || bananaCount ==3) {
            winningLine ="Congrats, you got three of the same fruit. You won 10 coins.";
            coinsWon = 10;
        }
        else {
            winningLine="Better luck next time :(";
        }

        player.setAmountOfCash(player.getAmountOfCash() + coinsWon);

        return winningLine;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
