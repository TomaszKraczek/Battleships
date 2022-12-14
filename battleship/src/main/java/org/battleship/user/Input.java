package org.battleship.user;
import java.util.Scanner;
import org.battleship.board.Board;
import org.battleship.ship.Square;
public class Input {

    private static Scanner scan = new Scanner(System.in);
    private String SelectedField;
    private int userChoice;

    Board board = new Board();
    Square[][] ocean = board.getBoard();
    private boolean validate(){
        return true;
    }

    public int getIntegerFromUser(){
        userChoice = scan.nextInt();
        return userChoice;
    }
    public String getStringFromUser(){
        return scan.next();
    }

    public int[] getConvertedCoordinates(){
        String userPosition = scan.next().toUpperCase();
        String[] coordinates = userPosition.split("",2);
        int firstCoordinate = userPosition.charAt(0) - 65;
        int secondCoordinate = Integer.parseInt(coordinates[1]) - 1;
        return new int[]{firstCoordinate, secondCoordinate};
    }

    public boolean checkIfFieldIsEmpty(int x, int y)
    {
        if (ocean[x][y].getSquareStatus() == "🟦"){
            return true;
        }
        return false;
    }
}
