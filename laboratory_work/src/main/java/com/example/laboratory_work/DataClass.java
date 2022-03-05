package com.example.laboratory_work;

public class DataClass {
    private final String words;
    private final char symbol;
    public DataClass(String words,char symbol){
        this.words = words;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getWords() {
        return words;
    }
}
