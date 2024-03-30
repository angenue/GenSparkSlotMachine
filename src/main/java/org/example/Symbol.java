package org.example;

public enum Symbol {
    WATERMELON("\uD83C\uDF49"),
    GRAPE("\uD83C\uDF47"),
    ORANGE("\uD83C\uDF4A"),
    BANANA("\uD83C\uDF4C"),
    CHERRY("\uD83C\uDF52"),
    SEVEN("7️⃣");
    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
