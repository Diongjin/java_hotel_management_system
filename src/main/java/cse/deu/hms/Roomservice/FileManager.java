/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.Roomservice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class FileManager {

    private final String paths = System.getProperty("user.dir");

    public List<String[]> readFile(String fileName) {
        List<String[]> data = new ArrayList<>();
        File file = new File(paths + "/src/" + fileName);

        if (!file.exists()) {
            return data;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split("\t"));
            }
        } catch (IOException e) {
            System.err.println("파일을 불러올 수 없습니다.: " + e.getMessage());
        }
        return data;
    }

    public void writeFile(String fileName, List<String[]> data, boolean append) {
        File file = new File(paths + "/src/" + fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (String[] line : data) {
                writer.write(String.join("\t", line));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("파일을 불러올 수 없습니다.: " + e.getMessage());
        }
    }

    public void updateFile(String fileName, List<String[]> updatedData) {
        writeFile(fileName, updatedData, false);
    }
}
