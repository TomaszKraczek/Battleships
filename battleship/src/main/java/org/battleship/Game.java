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

        Board player1Ships = new Board();
        Board player2Ships = new Board();
        Board player1Shots = new Board();
        Board player2Shots = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();


        monitor.messageToSetShips(player1);
        for (Ship ship : player1.getPlayerShips()) {
            placeShipsOnBoard(player1Ships, ship);
        }

        monitor.messageToSetShips(player2);
        for (Ship ship : player2.getPlayerShips()) {
            placeShipsOnBoard(player2Ships, ship);
        }


        while (player1.isAnyShipLeft() && player2.isAnyShipLeft()) {
            boolean isHited = false;
            do {
                isHited = doTurnAndReturnTrueIfHited(player1, player2, player1Ships, player2Ships, player1Shots);
                monitor.rollUpTerminal();
                if (!player2.isAnyShipLeft()) {
                    break;
                }
            } while (isHited);
            if (!player2.isAnyShipLeft()) {
                break;
            }

            do {
                isHited = doTurnAndReturnTrueIfHited(player2, player1, player2Ships, player1Ships, player2Shots);
                monitor.rollUpTerminal();
            } while (isHited);
            if (!player1.isAnyShipLeft()) {
                break;
            }

        }

        if (player1.isAnyShipLeft()) {
            monitor.displayGameResult(player1);
        } else {
            monitor.displayGameResult(player2);
        }

    }

    private boolean doTurnAndReturnTrueIfHited(Player player1, Player player2, Board player1Ships, Board player2Ships, Board player1Shots) {
        showPlayerRoundInfo(player1, player1Ships, player1Shots);
        monitor.messageToGetShootCoords(player1);
        int[] coords = reader.getConvertedCoordinates();
        if (player2Ships.getFieldInfo(coords[0], coords[1]).equals(SquareStatus.SHIP.getFieldStatusSymbol())) {
            playerHitATarget(player2, player2Ships, player1Shots, coords);
            return true;
        } else {
            playerDidNotHitATarget(player1Shots, coords, SquareStatus.MISSED, player2Ships);
            return false;
        }
    }

    private void playerDidNotHitATarget(Board player1Shots, int[] coords, SquareStatus missed, Board player2Ships) {
        player1Shots.changeFieldStatus(coords[0], coords[1], missed.getFieldStatusSymbol());
        player2Ships.changeFieldStatus(coords[0], coords[1], missed.getFieldStatusSymbol());
    }

    private void playerHitATarget(Player player2, Board player2Ships, Board player1Shots, int[] coords) {
        playerDidNotHitATarget(player1Shots, coords, SquareStatus.HIT, player2Ships);
        player2.markAnyShipIfHited(coords[0], coords[1]);
        makeAllPossibleShipSunk(player2, player2Ships, player1Shots);
    }

    private void showPlayerRoundInfo(Player player, Board player1Ships, Board player1Shots) {
        monitor.displayMessage("\t\t\t" + player.getPlayerName().toUpperCase() + "\n");
        monitor.displayMessage("Twoje strzały: ");
        monitor.displayBoard(player1Shots);
        monitor.displayMessage("Twoje statki: ");
        monitor.displayBoard(player1Ships);
    }

    private void makeAllPossibleShipSunk(Player player2, Board player2Ships, Board player1Shots) {
        for (Ship ship : player2.getPlayerShips()) {
            player2Ships.changeSquareToSunk(ship.getSquaresToSunkShip());
            player1Shots.changeSquareToSunk(ship.getSquaresToSunkShip());
        }
    }

    private void placeShipsOnBoard(Board board, Ship ship) {
        monitor.displayBoard(board);
        boolean isPossible = false;
        int[] coords;
        String choice;
        do {
            monitor.displayMessage(String.format("Chcesz rozmieścić: %s", ship.getType().name()));
            monitor.displayMessage("Statek ma " + ship.getType().getShipSize() + " jednostki długości \n");
            monitor.displayMessage("Wybierz współrzędne (A-J)(1-10): ");
            coords = reader.getConvertedCoordinates();
            monitor.displayMessage("Podaj kierunek ustawienia statku: ");
            choice = reader.getStringFromUser();
            try {
                isPossible = checkIfAllFieldAreFree(board, ship, coords[0], coords[1], choice);
                if (!isPossible) {
                    System.out.println("Źle ustawiłeś statek");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
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
            case "lewo":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "prawo":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "góra", "gora":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
            case "dół", "doł", "dol":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first + i, second, SquareStatus.SHIP);
                    ship.addPartOfShip(partCoord);
                }
                board.addShipToBoard(ship);
                break;
        }
    }

    private boolean checkIfAllFieldAreFree(Board board, Ship ship, int first, int second, String choice) {

        switch (choice) {
            case "lewo":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second - i, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;
                    }
                }
                break;
            case "prawo":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first, second + i, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;
                    }
                }
                break;
            case "góra", "gora":
                for (int i = 0; i < ship.getType().getShipSize(); i++) {
                    Square partCoord = new Square(first - i, second, SquareStatus.SHIP);
                    if (!board.areFieldsAroundEmpty(partCoord)) {
                        return false;
                    }
                }
                break;
            case "dół", "doł", "dol":
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
