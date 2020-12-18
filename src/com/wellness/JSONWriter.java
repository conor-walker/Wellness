package com.wellness;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;

public class JSONWriter {

    public static void writeLog(int rating, String module) throws IOException, ParseException {
        String currentDate = LocalDate.now().toString(); //gets todays date
        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";

        JSONObject day = pastData(); //working fine
        JSONObject categoryRating = currentData();
        categoryRating.put(module,rating);
        categoryRating.remove("TempKey"); //removes temporary key if present

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

    public static JSONObject currentData() throws IOException, ParseException {
        String currentDate = LocalDate.now().toString(); //gets todays date
        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";

        JSONObject jsonObj = pastData();
        System.out.println("past data" + jsonObj);

        return (JSONObject) jsonObj.get(currentDate);
    }

    public static JSONObject pastData() throws IOException, ParseException {
        createFileIfEmpty();
        String currentDate = LocalDate.now().toString(); //gets todays date
        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";

        JSONObject empty = new JSONObject();
        empty.put("TempKey","TempValue"); //initialises object, deletes

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(testPath);

        JSONObject historyData = (JSONObject) parser.parse(reader);
        if (historyData.get(currentDate) == null) {
            historyData.put(currentDate, empty);
        }

        reader.close();
        return historyData;
    }

    public static void createFileIfEmpty() throws IOException {
        String testPath = "c:\\Users\\\\Conor\\Desktop\\test.json";
        File file = new File(testPath);
        if(file.length()==0){
            String init = "{}";
            BufferedWriter writer = new BufferedWriter(new FileWriter(testPath));
            writer.write(init);
            writer.close();
        }
    }
}
