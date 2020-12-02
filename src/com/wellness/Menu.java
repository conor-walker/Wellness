package com.wellness;
import java.util.Scanner;

public class Menu {
    public static void welcomeMenu() {
        String userName = "Conor";
        String welcomeMessage = ("Welcome to your wellness tracker, "+userName+". :)");
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
        System.out.println("(0) to Quit");

        Scanner getUserChoice = new Scanner(System.in);
        int userChoice = getUserChoice.nextInt();


        switch (userChoice){
            case 1:
                Exercise.GetSetExercise();
            case 2:
                Food.GetSetFood();
            case 3:
                Hygiene.GetSetHygiene();
            case 4:
                Medicine.GetSetMedicine();
            case 5:
                Mood.GetSetMood();
            case 6:
                Sleep.GetSetSleep();
            case 0:
                System.out.println("Thank you! Have a good day!");
                System.exit(0);
        }
    }

}
