package org.battleship.board;


import org.battleship.user.Input;
import org.battleship.util.Random;
import org.battleship.Game;
import java.util.ArrayList;
import java.util.List;


public class BoardFactory {
    Random random = new Random();
    Input input = new Input();
    Game game = new Game();
    public void randomPlacement(Board board) {

        List<Integer> XandY = new ArrayList<>();
        XandY = random.generateRandomXandY();
        int x = XandY.get(0);
        int y = XandY.get(1);
        boolean work = true;
        while (work){
            if (input.checkIfFieldIsEmpty(x, y)){

        }

    }}

    public String generateDirection(){
        int directionNumber = random.nextInt(4);
        String res = "";
        switch (directionNumber) {
            case 0: res = "left";
            break;
            case 1: res = "right";
            break;
            case 2: res = "up";
            break;
            case 3: res =  "down";
            break;
        }
        return res;
    }
    public void manualPlacement(Board board) {
    }
}

