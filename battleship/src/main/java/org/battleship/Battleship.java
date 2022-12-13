package org.battleship;

import org.battleship.board.Board;
import org.battleship.ship.SquareStatus;
import org.battleship.view.Display;

public class Battleship {
    public static void main(String[] args) {
        Board board1 = new Board();
        Display monitor = new Display();
        board1.setBoardField(0, 2, SquareStatus.HIT.getFieldStatusSymbol());
        monitor.displayBoard(board1);

    }
}