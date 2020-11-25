package com.wellness;

import java.util.Scanner;

public class Medicine{
    private static int MedInput(){
        int medRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being best and 1 being worst - how are you feeling?");
        Scanner GetMed = new Scanner(System.in);

        Boolean valid = false;

        while(!valid) {
            try {
                medRating = GetMed.nextInt();
                if(medRating>5 || medRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetMed.nextLine();
            }
        }
        //TODO write medRating to data file
        return medRating;
    }
    private static String EvaluateMed(int medRating){
        String Feedback;
        switch (medRating){
            case 2:
                Feedback = "Sounds like you're having problems :(";
            case 1:
                Feedback = "Sounds like you're having problems :(";
            default:
                Feedback = "Looks like you're doing okay! :)";
        }
        return Feedback;
    }
    public static void GetSetMedicine(){
        System.out.println(EvaluateMed(MedInput()));
        Menu.MainMenu();
    }

}
