package org.battleship.ship;

import java.util.List;

public enum ShipType {
    BATTLESHIP(4, 1),DESTROYER(3, 2), CRUISER(2, 3), SUBMARINE(1, 4);

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
