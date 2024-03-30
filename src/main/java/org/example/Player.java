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

    public void checkForSufficientCoins() throws InsufficientFundsException {
        if (this.amountOfCash < 5) {
            System.out.println("Insufficient funds. You need more than 5 coins to play.");
            throw new InsufficientFundsException("Insufficient funds. You need more than 5 coins to play.");
        }
    }

    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

}
