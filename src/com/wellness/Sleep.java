package com.wellness;

import java.util.Scanner;

//TODO - make sleep evaluation in hours, rather than a rating scale
public class Sleep {
    private static int SleepInput(){
        int sleepRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how did you sleep last night?");
        Scanner GetSleep = new Scanner(System.in);

        boolean valid = false;

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
        return sleepRating;
    }
    private static String EvaluateSleep(int sleepRating){
        String Feedback;
        LogWriter.writeLog(sleepRating,"Sleep");
        switch (sleepRating){
            case 5:
            case 4:
                Feedback = "That's great! Being well rested is important :)";
                break;
            case 3:
                Feedback = "That's okay! You're doing well :)";
            case 2:
            case 1:
                Feedback = "Sounds like you're having problems :( You might want to try turning off your electronics " +
                        "a few hours before you go to bed, or look up some recommendations - if you haven't already";
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
