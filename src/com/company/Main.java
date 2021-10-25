package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int GetRandom(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static String[][] BoardSetUp(int rows, int columns) {
        String[][] initialBoard = new String[rows][columns];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                initialBoard[i][j] = "[ ]";
            }
        }
        return initialBoard;
    }


    public static String[][] printBoard(String[][] array, boolean change, int RowChange, int columnChange, boolean present) {
        if (change) {
            if (present) {
                array[RowChange][columnChange] = "[✔]";
            } else {
                array[RowChange][columnChange] = "[✘]";
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    public static String[][] Money(String[][] table) {            //allows the board to be passed into the method
        for (int i = 0; i < (table.length * table[0].length) / 2.5; i++) {          //30% of the squares contain money
            table[((GetRandom(10)))][((GetRandom(8)))] = Integer.toString(GetRandom(1000));
        }
        return table;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] cleanBoard = printBoard(BoardSetUp(10, 8), false, 0, 0, false);
        String board[][] = Money(BoardSetUp(10, 8));
        int userTotal1 = 0;
        int userTotal2 = 0;
        for (int i = 0; i < 10; i++) {
            boolean money = false;
            int player = (i % 2) + 1;
            System.out.println("player " + player + " Which row would you like to search?");
            int row = input.nextInt();
            System.out.println("player " + player + " Which column would you like to search?");
            int column = input.nextInt();
            if ((row > 10) || (column > 8)) {
                System.out.println("You were digging for coins outside the map.");
            } else {
                char firstChar = board[(row - 1)][(column - 1)].charAt(0);
                if (firstChar != '[') {
                    if (player == 1) {
                        userTotal1 = userTotal1 + (Integer.parseInt(board[(row - 1)][(column - 1)]));
                        System.out.println("You found " + board[(row - 1)][(column - 1)] + " and your user total is now " + userTotal1);
                    } else {
                        userTotal2 = userTotal2 + (Integer.parseInt(board[(row - 1)][(column - 1)]));
                        System.out.println("You found " + board[(row - 1)][(column - 1)] + " and your user total is now " + userTotal2);
                    }money = true;
                } else {
                    System.out.println("UNLUCKY!!!!!!");

                }cleanBoard = printBoard(cleanBoard, true, row - 1, column - 1, money);
            }


        }
        System.out.println(userTotal1);
        System.out.println(userTotal2);
    }
}

