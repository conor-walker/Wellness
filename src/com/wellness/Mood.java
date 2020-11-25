package com.wellness;

import java.util.Scanner;

public class Mood {
    private static int MoodInput(){
        int moodRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how are you feeling?");
        Scanner GetMood = new Scanner(System.in);

        Boolean valid = false;

        while(!valid) {
            try {
                moodRating = GetMood.nextInt();
                if(moodRating>5 || moodRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetMood.nextLine();
            }
        }
        //TODO write moodRating to data file
        return moodRating;
    }
    private static String EvaluateMood(int moodRating){
        String Feedback;
        switch (moodRating){
            case 5:
                Feedback = "Looks like you're doing well! :)";
            case 4:
                Feedback = "Looks like you're doing well! :)";
            case 3:
                Feedback = "Looks like you're doing okay! :)";
            case 2:
                Feedback = "Sounds like you're having problems :(";
            case 1:
                Feedback = "Sounds like you're having problems :(";
            default:
                Feedback = "Looks like you're doing okay! :)";
        }
        return Feedback;
    }
    public static void GetSetMood(){
        System.out.println(EvaluateMood(MoodInput()));
        Menu.MainMenu();
    }
}
