package org.battleship.ship;

public class Square {
    private int x;
    private int y;
    private String squareStatus;

    public Square(int x, int y, SquareStatus status) {
        this.x = x;
        this.y = y;
        this.squareStatus = status.getFieldStatusSymbol();
    }

    public String getSquareStatus(){
        return squareStatus;
    }
    public void setSquareStatus(String status){
        this.squareStatus = status;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(SquareStatus status){
        squareStatus = status.getFieldStatusSymbol();
    }
    public int getXPosition(){
        return x;
    }
    public int getYPosition(){
        return y;
    }


}

