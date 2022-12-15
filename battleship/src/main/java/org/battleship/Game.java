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
            playerTurn(player1, player2, player1Ships, player2Ships, player1Shots);
            if (!player2.isAnyShipLeft()){break;}
            playerTurn(player2, player1, player2Ships, player1Ships, player2Shots);
            if (!player1.isAnyShipLeft()){break;}
        }

        if(player1.isAnyShipLeft()){
            monitor.displayGameResult(player1);
        } else {
            monitor.displayGameResult(player2);
        }

    }

    private void playerTurn(Player player1, Player player2, Board player1Ships, Board player2Ships, Board player1Shots) {
        showPlayerRoundInfo(player1, player1Ships, player1Shots);
        monitor.messageToGetShootCoords(player1);
        int[] coords = reader.getConvertedCoordinates();
        if(player2Ships.getFieldInfo(coords[0], coords[1]) == SquareStatus.SHIP.getFieldStatusSymbol()){
            player1Shots.changeFieldStatus(coords[0], coords[1], SquareStatus.HIT.getFieldStatusSymbol());
            player2Ships.changeFieldStatus(coords[0], coords[1], SquareStatus.HIT.getFieldStatusSymbol());
            player2.markAnyShipIfHited(coords[0], coords[1]);
        } else {
            player1Shots.changeFieldStatus(coords[0], coords[1], SquareStatus.MISSED.getFieldStatusSymbol());
            player2Ships.changeFieldStatus(coords[0], coords[1], SquareStatus.MISSED.getFieldStatusSymbol());
        }
    }

    private void showPlayerRoundInfo(Player player ,Board player1Ships, Board player1Shots) {
        monitor.displayMessage(player.getPlayerName().toUpperCase());
        monitor.displayMessage("Twoje strzały: ");
        monitor.displayBoard(player1Shots);
        monitor.displayMessage("Twoje statki: ");
        monitor.displayBoard(player1Ships);
    }

    private void makeAllPossibleShipSunk(Player player2, Board player2Ships) {
        for (Ship ship : player2.getPlayerShips()) {
            player2Ships.changeSquareToSunk(ship.getSquaresToSunkShip());
        }
    }

    private void placeShipsOnBoard(Board board, Ship ship) {
        monitor.displayBoard(board);
        boolean isPossible = false;
        int[] coords;
        String choice;
        do
        {
            System.out.println("Chcesz rozmieścić " + ship.getType().name());
            System.out.println("Statek ma " + ship.getType().getShipSize() + " jednostki długości");
            monitor.displayMessage("Wybierz współrzędne (A-J)(1-10): ");
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
            case "left", "lewo":
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
            case "left", "lewo":
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
