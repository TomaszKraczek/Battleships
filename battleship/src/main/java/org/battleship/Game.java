package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Input;
import org.battleship.user.Player;
import org.battleship.view.Display;


public class Game {
    private final static Display monitor = new Display();
    private final static Input reader = new Input();

    public void playGame() {

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board1 = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();


        System.out.println("\nWelcome in BattleShip Game!!!\n");
        System.out.println("     You have: \n" +
                " 1 * Carrier - 5 fields\n" +
                " 1 * battleship - 4 fields\n" +
                " 2 * cruiser - 3 fields\n" +
                " 3 * submarine - 3 fields\n" +
                " 3 * destroyer - 2 fields\n" +
                "Set them up on the map by choosing coordinates!:");


        for (Ship ship : player1.getPlayerShips()) {
            placeShipOnBoard(board1, ship);
        }
        monitor.displayBoard(board1);

    }

    private void placeShipOnBoard(Board board1, Ship ship) {
        monitor.displayBoard(board1);
        boolean isPossible = false;
        int[] coords;
        String choice;
        do
        {
            System.out.println("You are placing " + ship.getType().name());
            System.out.println("It has " + ship.getType().getShipSize() + " fields");
            monitor.displayMessage("Pick Coordinates(a-j)(1-10): ");
            monitor.displayMessage(" ");
            coords = reader.getConvertedCoordinates();
            System.out.println("Write direction to set ship: ");
            choice = reader.getStringFromUser();
            try{
            isPossible = checkIfAllFieldAreFree(board1, ship, coords[0], coords[1], choice);
            if (!isPossible){
                System.out.println("Źle ustawiłeś statek");
            }
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Nie można tak, wyjechałeś za linię");
            }
        } while (!isPossible);

        setShipOnBoard(board1, ship, coords[0], coords[1], choice);


        for (int b = 0; b < 42; b++) {
            System.out.println(" ");
        }
    }


    private void setShipOnBoard(Board board, Ship ship, int first, int second, String choice) {
        switch (choice) {
            case "left":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "right":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "up":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "down":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first + i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
        }
    }
    private boolean checkIfAllFieldAreFree(Board board, Ship ship, int first, int second, String choice){

        switch (choice) {
            case "left":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)){
                        return false;}
                        }
                break;
            case "right":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;
                    }
                        }
                break;
            case "up":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;}
                        }
                break;
            case "down":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first + i, second, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;
                    }
                        }
                break;
        }
       return true;
    }

}
