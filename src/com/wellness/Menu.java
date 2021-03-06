package com.wellness;
import java.util.Scanner;
//TODO - could greatly simplify module system using a parent Module class with each module being a subclass.
// Would like to have graphs/charts to show progress - would need ability to look up days & ratings for that

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
        boolean valid = false;
        int userChoice = 0;

        while (!valid) {
            try {
                userChoice = getUserChoice.nextInt();
                if (userChoice > 6 || userChoice < 0) {
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 0 and 3: ");
                getUserChoice.nextLine();
            }
        }

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
                LogWriter.endOfDay();
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        Menu.welcomeMenu();
    }
}
