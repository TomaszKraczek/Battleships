package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.ShipType;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Player;
import org.battleship.view.Display;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void playGame() {
        Display monitor = new Display();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Board board1 = new Board();

        player1.generatePlayerShipList();
        player2.generatePlayerShipList();

        player1.showShipList();
        System.out.println("drugi player \n");
        player2.showShipList();

        monitor.displayBoard(board1);






    }
}
