package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.ShipType;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Input;
import org.battleship.user.Player;
import org.battleship.view.Display;

import java.util.List;


public class Game {
    private final static Display monitor = new Display();
    private final static Input reader = new Input();

    public void playGame() {

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        Board player1Ships = new Board();
        Board player2Ships = new Board();
        Board player1Shots = new Board();
        Board player2Shots = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();




//        System.out.println("\nWelcome in BattleShip Game!!!\n");
//        System.out.println("     You have: \n" +
//                " 1 * Carrier - 5 fields\n" +
//                " 1 * battleship - 4 fields\n" +
//                " 2 * cruiser - 3 fields\n" +
//                " 3 * submarine - 3 fields\n" +
//                " 3 * destroyer - 2 fields\n" +
//                "Set them up on the map by choosing coordinates!:");

        monitor.messageToSetShips(player1);
        for (Ship ship : player1.getPlayerShips()) {
            placeShipsOnBoard(player1Ships, ship);
        }

        monitor.messageToSetShips(player2);
        for (Ship ship : player2.getPlayerShips()) {
            placeShipsOnBoard(player2Ships, ship);
        }


        while (player1.isAnyShipLeft() && player2.isAnyShipLeft()){
            showPlayerRoundInfo(player1Ships, player1Shots);
            monitor.messageToGetShootCoords(player1);
            int[] coords = reader.getConvertedCoordinates();
            if(player2Ships.getFieldInfo(coords[0], coords[1]) == SquareStatus.SHIP.getFieldStatusSymbol()){
                player1Shots.changeFieldStatus(coords[0], coords[1], SquareStatus.HIT.getFieldStatusSymbol());
                player2Ships.changeFieldStatus(coords[0], coords[1], SquareStatus.HIT.getFieldStatusSymbol());
                player2.markAnyShipIfHited(coords[0], coords[1]);
                makeAllPossibleShipSunk(player2, player2Ships);
            }
            monitor.displayBoard(player2Ships);
            System.out.println("tutaj widać trafienia 1 gracza test");;
//            System.out.println(player2.isAnyShipLeft());
        }

        System.out.println("wygrał gracz pierwszy");

    }

    private void makeAllPossibleShipSunk(Player player2, Board player2Ships) {
        for (Ship ship : player2.getPlayerShips()) {
            player2Ships.changeSquareToSunk(ship.getSquaresToSunkShip());
        }
    }

    private void showPlayerRoundInfo(Board player1Ships, Board player1Shots) {
        monitor.displayMessage("PLAYER 1: ");
        monitor.displayMessage("Twoje strzały: ");
        monitor.displayBoard(player1Shots);
        monitor.displayMessage("Twoje statki: ");
        monitor.displayBoard(player1Ships);
    }

    private void placeShipsOnBoard(Board board, Ship ship) {
        monitor.displayBoard(board);
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
            isPossible = checkIfAllFieldAreFree(board, ship, coords[0], coords[1], choice);
            if (!isPossible){
                System.out.println("Źle ustawiłeś statek");
            }
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Nie można tak, wyjechałeś za linię");
            }
        } while (!isPossible);

        setOneShipOnBoard(board, ship, coords[0], coords[1], choice);


        for (int b = 0; b < 42; b++) {
            System.out.println(" ");
        }
    }


    private void setOneShipOnBoard(Board board, Ship ship, int first, int second, String choice) {
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
