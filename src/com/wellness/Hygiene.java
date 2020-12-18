package com.wellness;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Hygiene {
    private static int HygieneInput(){
        int hygieneRating = 0;
        System.out.println("Please select (1) if you've not done any hygiene rituals, (2) if you've done some, and (3) if you've done all of your usual self-care routines!");
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
        try {
            JSONWriter.writeLog(hygieneRating,"Hygiene");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        switch (hygieneRating){
            case 3:
                Feedback = "You're doing great!";
            case 2:
                Feedback = "That's not bad! Try to do the rest if you can :)";
            case 1:
                Feedback = "Sounds like you're having problems :( Please try to do just one small thing if you can - it could make all the difference :)";
                break;
            default:
                Feedback = "Looks like you're doing okay! :)";
        }
        return Feedback;
    }
    public static void GetSetHygiene(){
        System.out.println(EvaluateHygiene(HygieneInput()));
        Menu.MainMenu();
    }
}
