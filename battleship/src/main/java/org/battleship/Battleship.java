package org.battleship;
import org.battleship.user.Input;
import org.battleship.view.Display;


public class Battleship {
    private final static Display monitor = new Display();
    private final static Input reader = new Input();
    public static void main(String[] args) {
//        BattleshipController controller = new BattleshipController();
//        controller.selectMenuOption();
            Game game = new Game();
            game.playGame();


    }
}