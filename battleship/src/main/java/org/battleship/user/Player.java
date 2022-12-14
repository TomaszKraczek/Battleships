package org.battleship.user;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.ShipType;

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

    public void setUpShips(Board board) {
        for (Ship ship : playerShips) {
//            ship.setOnBoard(Board board);
        }
    }
    public void showShipList(){
        for (Ship playerShip : playerShips) {
            System.out.println(playerShip.getType());
        }
    }
}
