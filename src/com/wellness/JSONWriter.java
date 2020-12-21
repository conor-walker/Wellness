package com.wellness;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;

public class JSONWriter {
    private static final String logPath = System.getProperty("user.home") + "/Desktop/WellnessLog.json";;
    private static final String currentDate = LocalDate.now().toString(); //gets todays date

    public static void writeLog(int rating, String module) throws IOException, ParseException {
        JSONObject categoryRating = currentData();
        categoryRating.put(module,rating);
        categoryRating.remove(null); //removes temporary key if present

        JSONObject day = pastData();
        day.put(currentDate, categoryRating);
        try {
            FileWriter file = new FileWriter(logPath);
            file.write(day.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject currentData() throws IOException, ParseException {
        JSONObject jsonObj = pastData();
        return (JSONObject) jsonObj.get(currentDate);
    }

    public static JSONObject pastData() throws IOException, ParseException {
        createFileIfEmpty();
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(logPath);

        JSONObject historyData = (JSONObject) parser.parse(reader);

        if (historyData.get(currentDate) == null) {
            JSONObject empty = new JSONObject();
            empty.put(null,null); //initialises empty object, deletes in writing logic after used
            historyData.put(currentDate, empty);
        }
        reader.close();
        return historyData;
    }

    public static void createFileIfEmpty() throws IOException {
        File file = new File(logPath);
        if(file.length()==0){
            String init = "{}"; //initialises file with braces - this will fool the JSON parser into working
            BufferedWriter writer = new BufferedWriter(new FileWriter(logPath));
            writer.write(init);
            writer.close();
        }
    }
}
