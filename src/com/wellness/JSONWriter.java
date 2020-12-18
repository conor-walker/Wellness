package com.wellness;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;

public class JSONWriter {

    public static void writeLog(int rating, String module) throws IOException, ParseException {
        LocalDate currentDate = LocalDate.now(); //gets todays date
        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";
        JSONObject categoryRating = JSONReader();

        categoryRating.put(module,rating);

        JSONObject day = new JSONObject();
        day.put(currentDate, categoryRating);

        try {
            FileWriter file = new FileWriter(testPath);
            file.write(day.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject JSONReader() throws IOException, ParseException {
        String currentDate = LocalDate.now().toString(); //gets todays date

        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(testPath);

        JSONObject jsonObj = null;

        try {
            jsonObj = (JSONObject)parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            FileWriter file = new FileWriter(testPath);
            JSONObject day = new JSONObject();
            day.put(currentDate, "");
            file.write(day.toJSONString());
        }

        JSONObject currentDayData = (JSONObject) jsonObj.get(currentDate);
        reader.close();
        return currentDayData;
    }

    public static void endOfDay() {
        String desktopPath= System.getProperty("user.home") + "\\Desktop\\userLog.txt";
        try (FileWriter file = new FileWriter(desktopPath,true)) {
            file.write("_______________________________");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
