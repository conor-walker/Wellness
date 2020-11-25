package com.wellness;

import java.util.Scanner;

//TODO - make sleep evaluation in hours, rather than a rating scale
public class Sleep {
    private static int SleepInput(){
        int sleepRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how are you feeling?");
        Scanner GetSleep = new Scanner(System.in);

        Boolean valid = false;

        while(!valid) {
            try {
                sleepRating = GetSleep.nextInt();
                if(sleepRating>5 || sleepRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetSleep.nextLine();
            }
        }
        //TODO write sleepRating to data file
        return sleepRating;
    }
    private static String EvaluateSleep(int sleepRating){
        String Feedback;
        switch (sleepRating){
            case 2:
                Feedback = "Sounds like you're having problems :(";
            case 1:
                Feedback = "Sounds like you're having problems :(";
                break;
            default:
                Feedback = "Looks like you're doing okay! :)";
        }
        return Feedback;
    }
    public static void GetSetSleep(){
        System.out.println(EvaluateSleep(SleepInput()));
        Menu.MainMenu();
    }

}
