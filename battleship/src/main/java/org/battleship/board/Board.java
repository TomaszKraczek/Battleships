package org.battleship.board;

import org.battleship.ship.Square;

public class Board {
    private Square[][] ocean = new Square[10][10];

    public Board() {
        for (int y=0; y<ocean.length; y++) {
            for (int x = 0; x < ocean[y].length; x++) {
                 ocean[x][y] = new Square(y, x);
            }
        }
    }

    public Square[][] getBoard() {
        return ocean;
    }
    public void setBoardField(int x, int y, String toChange){
        this.ocean[x][y].setSquareStatus(toChange);
    }
}
