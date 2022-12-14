package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Player;
import org.battleship.view.Display;

import java.util.Scanner;

public class Game {

    public void playGame() {
        Scanner scan = new Scanner(System.in);

        Display monitor = new Display();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board1 = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();


        for (Ship ship : player1.getPlayerShips()) {
            System.out.println("podaj pierwszą współrzędną");
            int first = scan.nextInt();
            System.out.println("Podaj drugą współrzędną");
            int second = scan.nextInt();
            System.out.println("podaj kierunek rozstawienia");
            String choice = scan.next();

            setShipOnBoard(board1, ship, first, second, choice);

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
