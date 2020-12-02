package com.wellness;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class LogWriter {

    public static void writeLog(int rating, String module) {
        LocalDate currentDate = LocalDate.now(); //gets todays date fo
        String ratingLogger = String.format(" %s rating: %d\n",module,rating);
        String desktopPath= System.getProperty("user.home") + "\\Desktop\\userLog.txt";
        try (FileWriter file = new FileWriter(desktopPath,true)) {
            file.write(currentDate + ratingLogger);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
