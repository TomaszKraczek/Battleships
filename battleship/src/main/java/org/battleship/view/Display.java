package org.battleship.view;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.user.Player;

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
    }
    public void displayGameResult(){
    }

    public void messageToSetShips(Player player){
        String s = String.format("\nHello %s! You can set up your ships: ", player.getPlayerName());
        System.out.println(s);
    }
    public void messageToGetShootCoords(Player player){
        System.out.println(String.format("%s Wybierz koordynaty do strzału: ", player.getPlayerName()));
    }

}
