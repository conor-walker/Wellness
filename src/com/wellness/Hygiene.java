package com.wellness;

import java.util.Scanner;

public class Hygiene {
    private static int HygieneInput(){
        int hygieneRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how are you feeling?");
        Scanner GetHygiene = new Scanner(System.in);

        boolean valid = false;

        while(!valid) {
            try {
                hygieneRating = GetHygiene.nextInt();
                if(hygieneRating>5 || hygieneRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetHygiene.nextLine();
            }
        }
        return hygieneRating;
    }
    private static String EvaluateHygiene(int hygieneRating){
        String Feedback="";
        LogWriter.writeLog(hygieneRating,"Hygiene");
        switch (hygieneRating){
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
    public static void GetSetHygiene(){
        System.out.println(EvaluateHygiene(HygieneInput()));
        Menu.MainMenu();
    }
}
