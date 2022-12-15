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
                " 2 * destroyer - 3 fields\n" +
                " 3 * cruiser - 2 fields\n" +
                " 4 * submarine - 1 fields\n" +
                "Set them up on the map by choosing coordinates!:");


        for (Ship ship : player1.getPlayerShips()) {
            int[] coords;
            String choice;
            do {
                monitor.displayBoard(board1);
                System.out.println("You are placing " + ship.getType().name());
                System.out.println("It has " + ship.getType().getShipSize() + " fields");
                System.out.println(" ");
                monitor.displayMessage("Pick Coordinates(a-j)(1-10): ");
                coords = reader.getConvertedCoordinates();
                if (ship.getType().getShipSize() != 1) {
                    System.out.println("podaj kierunek rozstawienia");
                    choice = reader.getStringFromUser();
                } else {
                    choice = "right";
                }
            }while(!setShipOnBoard(board1, ship, coords[0], coords[1], choice));


            for (int b = 0; b < 42; b++) {
                System.out.println(" ");
            }
        }
        monitor.displayBoard(board1);
        for (int b=0; b < 5; b++){
            System.out.println(" ");
        }
        System.out.println("        IT IS TIME TO HAVE FUN NOW !");
        System.out.println("             SHOT YOUR ENEMY");





    }


    private boolean setShipOnBoard(Board board, Ship ship, int first, int second, String choice) {
        switch (choice) {
            case "left":
                if(second - ship.getType().getShipSize() < 0){
                    System.out.println(" WYKRACZA POZA LEWĄ STRONE !");
                    return false;
                }
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "right":
                if(second + ship.getType().getShipSize() > 9){
                    System.out.println(" WYKRACZA POZA PRAWĄ STRONE !");
                    return false;
                }
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "up":
                if(first - ship.getType().getShipSize() < 0){
                    System.out.println(" WYKRACZA Z GÓRNEJ CZĘŚCI TABELI! ");
                    return false;
                }
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "down":
                if(first + ship.getType().getShipSize() > 9){
                    System.out.println(" WYKRACZA Z DOLNEJ CZĘŚCI TABELI! ");
                    return false;
                }
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first + i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
        }
        return true;
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
