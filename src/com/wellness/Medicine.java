package com.wellness;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Medicine {
    private static int MedInput() {
        System.out.println();
        int medRating = 0;
        System.out.println("Please enter (1) if you have taken none of your medicine/supplements, (2) for some, or (3) for all: ");
        Scanner GetMed = new Scanner(System.in);

        boolean valid = false;

        while (!valid) {
            try {
                medRating = GetMed.nextInt();
                if (medRating > 3 || medRating < 1) {
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 3: ");
                GetMed.nextLine();
            }
        }
        //TODO write medRating to data file
        return medRating;
    }

    private static String EvaluateMed(int medRating) {
        String Feedback;
        try {
            JSONWriter.writeLog(medRating,"Medicine");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        switch (medRating) {
            case 3:
                Feedback = "You're doing great!";
            case 2:
                Feedback = "That's not bad! Try to take the rest if you can :)";
            case 1:
                Feedback = "Sounds like you're having problems :( Do you think you'd be able to take even just one?";
                break;
            default:
                Feedback = "Looks like you're doing okay! :)";
        }
        return Feedback;
    }

    public static void GetSetMedicine() {
        System.out.println(EvaluateMed(MedInput()));
        Menu.MainMenu();
    }
}