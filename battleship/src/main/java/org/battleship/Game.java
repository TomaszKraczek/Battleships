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


        System.out.println("Welcome in BattleShip Game!!!");
        System.out.println("You have \n" +
                " 1 * Carrier - 5 fields\n" +
                " 1 * battleship - 4 fields\n" +
                " 2 * cruiser - 3 fields\n" +
                " 3 * submarine - 3 fields\n" +
                " 3 * destroyer - 2 fields\n" +
                "Set them up on the map by choosing coordinates!:");



        for (Ship ship : player1.getPlayerShips()) {
            monitor.displayBoard(board1);
            System.out.println("You are placing " + ship.getType().name());
            System.out.println("It has " + ship.getType().getShipSize() +" fields");
            System.out.println(" ");
            monitor.displayMessage("Pick Coordinates(a-j)(1-10): ");
            int[] coords = reader.getConvertedCoordinates();
            System.out.println("podaj kierunek rozstawienia");
            String choice = reader.getStringFromUser();

            setShipOnBoard(board1, ship, coords[0], coords[1], choice);

            for (int b=0; b <42; b++){
                System.out.println(" ");
            }
        }
        monitor.displayBoard(board1);

    }

    private static void setShipOnBoard(Board board1, Ship ship, int first, int second, String choice) {
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
