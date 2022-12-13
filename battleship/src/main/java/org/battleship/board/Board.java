package org.battleship.board;

import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;

import java.util.List;

public class Board {
    private Square[][] ocean = new Square[10][10];

    public Board() {
        for (int y=0; y<ocean.length; y++) {
            for (int x = 0; x < ocean[y].length; x++) {
                 ocean[x][y] = new Square(y, x, SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getBoard() {
        return ocean;
    }
    private void setBoardField(int x, int y, String toChange){
        this.ocean[x][y].setSquareStatus(toChange);
    }
    public void addShipToBoard(Ship ship){
        List<Square> shipCordinates = ship.getCoordsOfShip();
        for (Square shipCordinate : shipCordinates) {
            setBoardField(shipCordinate.getXPosition(), shipCordinate.getYPosition(), shipCordinate.getSquareStatus());
            }
        }

}
