package com.company;

import java.util.Random;

public class MineSweeper {
    public static char[][] createTable(int x, int y, int minePercentageOutOf100) {
        Random random = new Random();
        char[][] table = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (random.nextInt(99) <= minePercentageOutOf100-1) {
                    table[i][j] = '*';
                } else {
                    table[i][j] = '.';
                }
            }
        }
        return table;
    }

    public static char[][] replacePoints(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == '.'){
                    table[i][j] = checkSurrounding(table, i, j);
                }
            }
        }
        return table;
    }

    public static void printTable(char[][] table){
        for (char[] chars : table) {
            System.out.println(chars);
        }
    }

    private static char checkSurrounding(char[][] table, int x, int y) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (table[x + i][y + j] == '*') {
                        counter++;
                    }
                } catch (IndexOutOfBoundsException exc) {
                }
            }
        }
        return (char) (counter + 48);
    }
}
