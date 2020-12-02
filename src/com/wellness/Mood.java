package com.wellness;

import java.util.Scanner;

public class Mood {
    private static int MoodInput(){
        int moodRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how are you feeling?");
        Scanner GetMood = new Scanner(System.in);

        boolean valid = false;

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
        return moodRating;
    }
    private static String EvaluateMood(int moodRating){
        String Feedback="";
        LogWriter.writeLog(moodRating,"Mood");
        switch (moodRating){
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
    public static void GetSetMood(){
        System.out.println(EvaluateMood(MoodInput()));
        Menu.MainMenu();
    }
}
