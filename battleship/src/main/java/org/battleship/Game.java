package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Input;
import org.battleship.user.Player;
import org.battleship.util.Random;
import org.battleship.view.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public void playGame() {
        Display monitor = new Display();
        Input reader = new Input();

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board1 = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();

        monitor.displayBoard(board1);

        for (Ship ship : player1.getPlayerShips()) {
            monitor.displayMessageForShipPlacement(ship);
            int[] shipCoord = reader.getConvertedCoordinates();
            monitor.displayMessage("Chose direction for rest of the ship: ");
            String direction = reader.getStringFromUser();

            this.setShipOnBoard(board1, ship, shipCoord[0], shipCoord[1], direction);

            monitor.displayBoard(board1);
        }
    }

    private void setShipOnBoard(Board board1, Ship ship, int first, int second, String choice) {
        switch (choice) {
            case "left":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board1.addShipToBoard(ship);
                break;
            case "right":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board1.addShipToBoard(ship);
                break;
            case "up":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board1.addShipToBoard(ship);
                break;
            case "down":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first + i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board1.addShipToBoard(ship);
                break;
        }
    }

}
