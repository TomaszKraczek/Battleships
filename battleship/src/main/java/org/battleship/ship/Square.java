package org.battleship.ship;

public class Square {
    private int x;
    private int y;
    private String squareStatus = "\uD83D\uDFE6";

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getSquareStatus(){
        return squareStatus;
    }
    public void setSquareStatus(String status){
        this.squareStatus = status;
    }
}

