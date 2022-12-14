package org.battleship.board;

import org.battleship.ship.Ship;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;

import java.util.List;
import java.util.Objects;

public class Board {

    public final int BOARD_SIZE = 10;
    private Square[][] ocean = new Square[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        for (int y = 0; y < ocean.length; y++) {
            for (int x = 0; x < ocean[y].length; x++) {
                ocean[x][y] = new Square(y, x, SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getBoard() {
        return ocean;
    }

    private void setBoardField(int x, int y, String toChange) {
        this.ocean[x][y].setSquareStatus(toChange);
    }

    public void addShipToBoard(Ship ship) {
        List<Square> shipCordinates = ship.getCoordsOfShip();
        for (Square shipCordinate : shipCordinates) {
            setBoardField(shipCordinate.getXPosition(), shipCordinate.getYPosition(), shipCordinate.getSquareStatus());
        }
    }

    public boolean areFieldsAroundEmpty(Square coordinates) {
        int x = coordinates.getXPosition();
        int y = coordinates.getYPosition();
            if    (x == 0 && y == 0){
                if (ocean[x + 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())){
                    return true;
                }

        } else if (x == 9 && y == 0){
            if (ocean[x - 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                    ocean[x][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())){
                return true;
            }
        } else if (x == 0 && y == 9){
                if (ocean[x + 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                        ocean[x][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())){
                    return true;
                }
        } else if (x == 9 && y == 9 ){
                if (ocean[x - 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                        ocean[x][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())){
                    return true;
                }

        } else if (x == 0 || x == 9) {
            if (ocean[x][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())) {
                return true;
                }
        } else if (y == 0 || y == 9) {
            if (ocean[y][x + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[y][x - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())){
                return true;
                }

        } else if (
                ocean[x + 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x - 1][y].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x + 1][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x + 1][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x - 1][y - 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol()) &&
                ocean[x - 1][y + 1].getSquareStatus().equals(SquareStatus.EMPTY.getFieldStatusSymbol())) {
            return true;
        } else {
            return false;
        }
        return false;
    }

    public String getFieldInfo(int x, int y){
            String status = ocean[x][y].getSquareStatus();
        return status;
    }
    public void changeFieldStatus(int x, int y, String status){
        ocean[x][y].setSquareStatus(status);
    }

}
