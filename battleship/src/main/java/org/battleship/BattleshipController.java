package org.battleship;

import org.battleship.user.Input;
import org.battleship.view.Display;

public class BattleshipController {
    private final static Display monitor = new Display();
    private final static Input reader = new Input();

    public void selectMenuOption() {
        boolean isRunning = true;
        while (isRunning) {
            monitor.displayMenu();
            String option = reader.getStringFromUser();
            switch (option) {
                case "1" -> {
                    monitor.displayGameOptions();
                    String choice = reader.getStringFromUser();
                    BattleshipController controller = new BattleshipController();
                    controller.selectGameOptions(choice);
                }
                case "2" -> {
                }
                case "3" -> {
                    monitor.displayMessage("Do zobaczenia!! :)");
                    isRunning = false;
                }
                default -> monitor.displayMessage("Nie ma takiej opcji! :)");
            }
        }
    }

    private void selectGameOptions(String choice) {
        switch (choice) {
            case "1" -> {
                Game game = new Game();
                game.playGame();
            }
            case "2" -> monitor.displayMessage("Jeszcze nie zrobione :(");
            default -> monitor.displayMessage("Nie ma takiej opcji! :)");
        }
    }
}
