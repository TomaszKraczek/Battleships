package org.battleship.view;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;

public class Display {


    public void displayBoard(Board board){
        Square[][] ocean =  board.getBoard();
        int i = 1;
        int columnNumber = 1;
            System.out.print("   ");
        while (columnNumber < ocean.length + 1){
            System.out.print(columnNumber + "  ");
            columnNumber++;
            if (columnNumber == 5) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (Square[] squares : ocean) {
            System.out.print((char)(64 + i) + " ");
            i++;
            for (Square square : squares) {
                System.out.print(square.getSquareStatus() + " ");
            }
            System.out.println();
        }
    }
    public void displayMessage(String message){
        System.out.println(message);
    }
    public void displayMenu(){

    }
    public void displayGameResult(){

    }
}
