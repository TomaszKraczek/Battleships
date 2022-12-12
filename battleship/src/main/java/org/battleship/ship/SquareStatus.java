package org.battleship.ship;

public enum SquareStatus {
    EMPTY("O"), SHIP("!"), HIT("*"), MISSED("%");

    private final String status;

    SquareStatus(String status){
        this.status = status;
    }
    public String getCharacter(){
        return status;
    }
}
