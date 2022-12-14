package org.battleship.board;


import org.battleship.util.Random;
import java.util.ArrayList;
import java.util.List;


public class BoardFactory {
    Random random = new Random();

    private int X;
    private int y;
    public enum Direction{
        LEFT,
        UP,
        RIGHT,
        DOWN;
    }

    public void randomPlacement(Board board) {

        List<Integer> XandY = new ArrayList<>();
        XandY = random.generateRandomXandY();

    }
    public void manualPlacement(Board board) {
    }
}

