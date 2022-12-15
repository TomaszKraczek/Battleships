package org.battleship.ship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    private ShipType type;

    private List<Square> coordsOfShip = new ArrayList<>();

    public Ship(ShipType type){
        this.type = type;
        this.size = type.getShipSize();
    }

    public void makeShipPartHited(int x, int y){
        for (Square square : coordsOfShip) {
            if(square.isShipOnField(x, y)){
                square.setSquareStatus(SquareStatus.HIT.getFieldStatusSymbol());
            }
        }
    }

    public ShipType getType (){
        return type;
    }

    public void setCoordsOfShip(List<Square> coordsOfShip) {
        this.coordsOfShip = coordsOfShip;
    }
    public List<Square> getCoordsOfShip(){
        return coordsOfShip;
    }

    public void addPartOfShip(Square coords){
        coordsOfShip.add(coords);
    }
}
