package com.wellness;

import java.util.Scanner;

public class Food {
    private static int FoodInput(){
        int foodRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how have you been eating?");
        Scanner GetFood = new Scanner(System.in);

        Boolean valid = false;

        while(!valid) {
            try {
                foodRating = GetFood.nextInt();
                if(foodRating>5 || foodRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetFood.nextLine();
            }
        }
        //TODO write foodRating to data file
        return foodRating;
    }
    private static String EvaluateFood(int foodRating){
        String Feedback="";
        switch (foodRating){
            case 5:
                Feedback = "Looks like you're doing well! :)";
            case 4:
                Feedback = "Looks like you're doing well! :)";
                break;
            case 3:
                Feedback = "Looks like you're doing okay! :)";
                break;
            case 2:
                Feedback = "Sounds like you're having problems :(";
            case 1:
                Feedback = "Sounds like you're having problems :(";
                break;
        }
        return Feedback;
    }
    public static void GetSetFood(){
        System.out.println(EvaluateFood(FoodInput()));
        Menu.MainMenu();
    }
}
