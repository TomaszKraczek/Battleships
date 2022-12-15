package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Input;
import org.battleship.user.Player;
import org.battleship.view.Display;


public class Game {

    public void playGame() {
        Display monitor = new Display();
        Input reader = new Input();

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
            monitor.displayBoard(board1);
            boolean isPossible = false;
            int[] coords;
            String choice;
            int counterOfAttempts = 0;
            do
            {
                if (counterOfAttempts > 0){
                    System.out.println("Nie możesz tak rozstawić statku!");
                }
                System.out.println("You are placing " + ship.getType().name());
                System.out.println("It has " + ship.getType().getShipSize() + " fields");
                monitor.displayMessage("Pick Coordinates(a-j)(1-10): ");
                System.out.println(" ");
                coords = reader.getConvertedCoordinates();
                System.out.println("Write direction to set ship: ");
                choice = reader.getStringFromUser();
                try{
                isPossible = checkIfAllFieldAreFree(board1, ship, coords[0], coords[1], choice);
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Nie można tak, wyjechałeś za linię");
                }
                counterOfAttempts++;
            } while (!isPossible);

            setShipOnBoard(board1, ship, coords[0], coords[1], choice);


            for (int b = 0; b < 42; b++) {
                System.out.println(" ");
            }
        }
        monitor.displayBoard(board1);

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
