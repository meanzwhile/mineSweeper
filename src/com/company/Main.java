package com.company;

public class Main {

    public static void main(String[] args) {
        char[][] table = MineSweeper.createTable(10,10, 25);

        MineSweeper.printTable(table);

        MineSweeper.replacePoints(table);

        MineSweeper.printTable(table);
    }
}
