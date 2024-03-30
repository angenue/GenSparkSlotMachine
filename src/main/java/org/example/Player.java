package org.example;

public class Player {
    private int amountOfCash = 50;

    public Player() {
    }

    public int getAmountOfCash() {
        return amountOfCash;
    }

    public void setAmountOfCash(int amountOfCash) {
        this.amountOfCash = amountOfCash;
    }

    public void checkForSufficientCoins()  {
        if(this.amountOfCash < 5) {
            System.out.println("Insufficient funds. You need more than 5 coins to play.");
            System.exit(0);
        }
    }
}
