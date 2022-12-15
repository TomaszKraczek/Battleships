package org.battleship.ship;

import java.util.List;

public enum ShipType {
    CARRIER(5, 1), CRUISER(3, 2), BATTLESHIP(4, 1), DESTROYER(2, 2), SUBMARINE(3, 0);

    private final int shipSize;
    private final int shipQuantity;

    ShipType(int shipSize, int shipQuantity){
        this.shipSize = shipSize;
        this.shipQuantity = shipQuantity;
    }

    public int getShipSize(){
        return this.shipSize;
    }
    public int getShipQuantity(){
        return this.shipQuantity;
    }

}

/*
 1 * Carrier - 5 fields
 1 * battleship - 4 fields
 2 * cruiser - 3 fields
 3 * submarine - 3 fields
 3 * destroyer - 2 fields
 */
