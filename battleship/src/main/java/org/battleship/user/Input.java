package org.battleship.user;

import java.util.Scanner;
public class Input {

    private String SelectedField;
    private int userChoice;


    private boolean validate(){
        return true;
    }

    public int getIntegerFromUser(){
        Scanner scan = new Scanner(System.in);
        userChoice = scan.nextInt();
        return userChoice;
    }
}
