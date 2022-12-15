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
    }
}