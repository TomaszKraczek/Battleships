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
    public void displayMessageForShipPlacement(Ship ship){
        String s = String.format("Chose first coordinate for: %s", ship.getType());
        System.out.println(s);
    }
    public void displayMenu(){
        System.out.println("\n**STATKI**\nMENU:\n1. NOWA GRA\n2. NAJLEPSZE WYNIKI\n3. WYJŚCIE");
    }
    public void displayGameOptions(){
        System.out.println("\n1. GRACZ VS GRACZ\n2. GRACZ VS KOMPUTER");
    }
    public void displayGameResult(){

    }
}
