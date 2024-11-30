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
            System.err.println(fileName + " 파일이 존재하지 않습니다.");
            return data;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split("\t"));
            }
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류 발생: " + e.getMessage());
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
            System.err.println("파일을 쓰는 중 오류 발생: " + e.getMessage());
        }
    }

    public void updateFile(String fileName, List<String[]> updatedData) {
        writeFile(fileName, updatedData, false);
    }
}
