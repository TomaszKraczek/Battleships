package org.battleship.user;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.ShipType;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Ship> playerShips = new ArrayList<>();
    private int playerId;

    public Player(int playerId)
    {
        this.playerId = playerId;
    }

    public void generatePlayerShipList(){
        ShipType[] shipList = ShipType.values();
        for (ShipType shipType : shipList) {
            for (int i = 0; i < shipType.getShipQuantity(); i++) {
                playerShips.add(new Ship(shipType));
            }
        }
    }
    public List<Ship> getPlayerShips(){
        return playerShips;
    }

    public void deleteFromPlayerShipList(Ship ship){
        playerShips.remove(ship);
    }
    public void addToPlayerShipList(Ship ship){
        playerShips.add(ship);
    }

    public String getPlayerName(){
        return String.format("Player %s", playerId);
    }

    public void markAnyShipIfHited(int x, int y){
        for (Ship ship : playerShips) {
            ship.makeShipPartHited(x, y);
        }
    }
    public boolean isAnyShipLeft(){
        boolean isAlive = false;
        for (Ship ship : playerShips) {
            List<Square> cords = ship.getCoordsOfShip();
            for (Square field : cords) {
                if(field.getSquareStatus() == SquareStatus.SHIP.getFieldStatusSymbol()){
                    isAlive = true;
                }
            }
        }
        return isAlive;
    }
}
