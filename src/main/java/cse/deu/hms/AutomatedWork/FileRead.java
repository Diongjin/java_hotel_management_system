/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.AutomatedWork;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SAMSUNG
 */
public class FileRead {

    public int getCountWithinPeriod(File file, Date startDate, Date endDate, int dateColumnIndex) {
        int count = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length > dateColumnIndex) {
                    Date recordDate = dateFormat.parse(data[dateColumnIndex]);
                    if (!recordDate.before(startDate) && !recordDate.after(endDate)) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int calculateRevenue(File file, Date startDate, Date endDate, int revenueColumnIndex, int dateColumnIndex) {
        int totalRevenue = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length > Math.max(revenueColumnIndex, dateColumnIndex)) {
                    Date recordDate = dateFormat.parse(data[dateColumnIndex]);
                    if (!recordDate.before(startDate) && !recordDate.after(endDate)) {
                        totalRevenue += Integer.parseInt(data[revenueColumnIndex]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }
}
