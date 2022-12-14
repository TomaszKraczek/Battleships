package org.battleship.user;
import java.util.Scanner;
public class Input {

    private static Scanner scan = new Scanner(System.in);
    private String SelectedField;
    private int userChoice;


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
        int firstCoordinate,secondCoordinate;
        String userPosition;
        do{
            userPosition = scan.next().toUpperCase();
        }while(!userPosition.matches("^[a-jA-J]([1-9]{1}|10)$"));
        String[] coordinates = userPosition.split("",2);
        firstCoordinate = userPosition.charAt(0) - 65;
        secondCoordinate = Integer.parseInt(coordinates[1]) - 1;
        return new int[]{firstCoordinate, secondCoordinate};
    }
}