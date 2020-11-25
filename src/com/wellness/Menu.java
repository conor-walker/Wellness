package com.wellness;
import java.util.Scanner;

public class Menu {
    public static void welcomeMenu() {
        String userName = "Conor";
        String welcomeMessage = ("Welcome to your wellness tracker, "+userName+". :)" + "Please select from the following options:");
        System.out.println(welcomeMessage);
        MainMenu();
    }
    public static void MainMenu(){

        System.out.println("Please select from the following options:");
        System.out.println("(1) for Exercise");
        System.out.println("(2) for Food/Drink");
        System.out.println("(3) for Hygiene");
        System.out.println("(4) for Medication");
        System.out.println("(5) for Mood");
        System.out.println("(6) for Sleep");

        Scanner getuserChoice = new Scanner(System.in);
        int userChoice = getuserChoice.nextInt();


        switch (userChoice){
            case 1:
                Mood.GetSetMood();
        }
    }

}
