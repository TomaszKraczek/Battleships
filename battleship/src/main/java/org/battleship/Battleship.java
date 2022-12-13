package org.battleship;

import org.battleship.board.Board;
import org.battleship.user.Player;
import org.battleship.view.Display;

public class Battleship {
    public static void main(String[] args) {
        Board board1 = new Board();
        board1.setBoardField(0, 2, "\uD83D\uDFEB");
        board1.setBoardField(9,0, "\uD83D\uDFEB");
        Display monitor = new Display();
        monitor.displayBoard(board1);

    }
}