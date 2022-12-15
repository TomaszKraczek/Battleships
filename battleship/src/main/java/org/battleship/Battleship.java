package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.Ship;
import org.battleship.ship.ShipType;
import org.battleship.ship.Square;
import org.battleship.ship.SquareStatus;
import org.battleship.user.Input;
import org.battleship.user.Player;
import org.battleship.view.Display;

import java.util.ArrayList;
import java.util.List;

public class Battleship {
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();
//        Display monitor = new Display();
//        Input reader = new Input();
//        Board board1 = new Board();
//
//        Player player1 = new Player(1);
//        Player player2 = new Player(2);
//
//        Ship podwodna = new Ship(ShipType.SUBMARINE);
//        Ship kuter = new Ship(ShipType.DESTROYER);
//        List<Square> coords = new ArrayList<>();
//        coords.add(new Square(1, 1, SquareStatus.SHIP));
//        coords.add(new Square(1, 2, SquareStatus.SHIP));
//        podwodna.setCoordsOfShip(coords);
//        podwodna.getCoordsOfShip().get(0).setSquareStatus(SquareStatus.SHIP.getFieldStatusSymbol());
//        podwodna.getCoordsOfShip().get(1).setSquareStatus(SquareStatus.SHIP.getFieldStatusSymbol());
//        board1.addShipToBoard(podwodna);
//        player1.addToPlayerShipList(podwodna);
//
//        board1.changeFieldStatus(1,1, SquareStatus.HIT.getFieldStatusSymbol());
//
//        System.out.println(player1.isAnyShipLeft());
//
//        System.out.println(board1.getFieldInfo(1, 1));
//
//        monitor.displayBoard(board1);

    }
}