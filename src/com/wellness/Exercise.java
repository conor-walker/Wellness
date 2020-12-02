package com.wellness;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.Scanner;

public class Exercise {
    private static int ExerciseInput(){
        int exerciseRating = 0;
        System.out.println("On a scale of 1 to 5 - 5 being most active and 1 being least - how how active have you been?");
        Scanner GetExercise = new Scanner(System.in);

        boolean valid = false;

        while(!valid) {
            try {
                exerciseRating = GetExercise.nextInt();
                if(exerciseRating>5 || exerciseRating <1){
                    throw new Exception(""); // checks that input is in given range, moves to catch block if not
                }
                valid = true;
            } catch (Exception e) {
                System.out.println("Please ensure you're entering a number between 1 and 5: ");
                GetExercise.nextLine();
            }
        }
        //TODO write exerciseRating to data file
        return exerciseRating;
    }
    private static String EvaluateExercise(int exerciseRating){
        String Feedback="";
        LogWriter.writeLog(exerciseRating,"Exercise");
        switch (exerciseRating){
            case 5:
                Feedback = "Looks like you're doing great! :)";
            case 4:
                Feedback = "Looks like you're doing great! :)";
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
    public static void GetSetExercise(){
        System.out.println(EvaluateExercise(ExerciseInput()));
        Menu.MainMenu();
    }
    public static void writeLog(int rating) {
        LocalDate currentDate = LocalDate.now(); //gets todays date fo
        //TODO Read rating array. Append to rating array if present, otherwise create new array

        try (FileWriter file = new FileWriter("conor.txt",true)) {
            file.write(currentDate + " Exercise rating: " + rating + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
