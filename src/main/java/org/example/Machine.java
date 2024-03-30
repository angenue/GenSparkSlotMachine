package org.example;

import java.util.Arrays;
import java.util.Random;

public class Machine {
    private final Symbol[] SYMBOLS = Symbol.values();
    private Player player = new Player();

    public Machine() {
    }

    public void spinWheel() {
        player.checkForSufficientCoins();

        System.out.println("Spinning wheel...");

        //everytime player spins, it costs 5 coins
        player.setAmountOfCash(player.getAmountOfCash() - 5);
        System.out.println();
        System.out.println("Coins: " + player.getAmountOfCash());

        //generate array with random symbols every spin
        Symbol[] result = new Symbol[3];

        Random random = new Random();

        for(int i = 0; i < 3; i++) {
            result[i] = SYMBOLS[random.nextInt(SYMBOLS.length)];
        }

        System.out.println();

        System.out.println(Arrays.toString(result));

        System.out.println();

        winningCombinations(result);
    }

    //TODO: methods for winning combinations
    private void winningCombinations(Symbol[] symbols) {
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

        if(sevenCount == 3) {
            System.out.println("JACKPOT!! You win 30 coins");
            coinsWon = 30;
        } else if (sevenCount == 2) {
            System.out.println("Congrats, you got two 7's. You won 4 coins.");
            coinsWon = 4;
        }
        else if (sevenCount == 1) {
            System.out.println("You got one 7. You won 1 coin.");
            coinsWon = 1;
        }else if(watermelonCount == 3 || orangeCount == 3 || grapeCount == 3 || cherryCount == 3 || bananaCount ==3) {
            System.out.println("Congrats, you got three of the same fruit. You won 10 coins.");
            coinsWon = 10;
        }
        else {
            System.out.println("Better luck next time :(");
        }

        System.out.println();
        player.setAmountOfCash(player.getAmountOfCash() + coinsWon);
        System.out.println("Coins: " + player.getAmountOfCash());
        System.out.println();
    }
}
