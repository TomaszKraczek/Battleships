package org.battleship.ship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    private ShipType type;

    private int fieldsSunked;

    private List<Square> coordsOfShip = new ArrayList<>();

    public Ship(ShipType type){
        this.type = type;
        this.size = type.getShipSize();
    }

    public ShipType getType (){
        return type;
    }

    private boolean isSunk(){
        if (fieldsSunked == size){
            return true;
        }
        else return false;
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
