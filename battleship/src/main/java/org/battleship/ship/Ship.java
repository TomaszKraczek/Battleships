package org.battleship.ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {
    private final int size;
    private final ShipType type;

    private List<Square> coordsOfShip = new ArrayList<>();

    public Ship(ShipType type) {
        this.type = type;
        this.size = type.getShipSize();
    }

    public void makeShipPartHited(int x, int y) {
        for (Square square : coordsOfShip) {
            if (square.isShipOnField(x, y)) {
                square.setSquareStatus(SquareStatus.HIT.getFieldStatusSymbol());
            }
        }
    }

    public ShipType getType() {
        return type;
    }

    public void setCoordsOfShip(List<Square> coordsOfShip) {
        this.coordsOfShip = coordsOfShip;
    }

    public List<Square> getCoordsOfShip() {
        return coordsOfShip;
    }

    public void addPartOfShip(Square coords) {
        coordsOfShip.add(coords);
    }

    public List<Square> getSquaresToSunkShip() {
        List<Square> list = new ArrayList<>();
        int count = 0;
        for (Square square : coordsOfShip) {
            if (square.getSquareStatus().equals(SquareStatus.HIT.getFieldStatusSymbol())) {
                count++;
            }
        }
        if (count == size) {
            list.addAll(coordsOfShip);
        }
        return list;
    }
}
