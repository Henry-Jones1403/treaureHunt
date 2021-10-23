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
                System.out.print(initialBoard[i][j]);
            }
            System.out.println();
        }
        return initialBoard;
    }

public static void printBoard(String[][] array, String RowChange, String columnChange){
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 8; j++) {
            array[i][j] = "[ ]";
            System.out.print(array[i][j]);
        }
        System.out.println();
    }

}
    public static String[][] Money(String[][] table) {            //allows the board to be passed into the method
        for (int i = 0; i < (table.length * table[0].length) / 2.5; i++) {          //30% of the squares contain money
            table[((GetRandom(10)))][((GetRandom(8)))] = Integer.toString(GetRandom(1000));

        }
        return table;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String board[][] = Money(BoardSetUp(10, 8));
        for (int i = 0; i < 10; i++) {
            int userTotal = 0;
            System.out.println("Which row would you like to search?");
            int row = input.nextInt();
            System.out.println("Which column would you like to search?");
            int column = input.nextInt();
            char firstChar = board[row][column].charAt(0);
            if (firstChar !=('[')){
                userTotal = userTotal + (Integer.parseInt(board[row][column]));
            }
            else{
                System.out.println("UNLUCKY!!!!!!");
            }
        }




    }
}

