/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.Restaurantservice;

import java.io.*;
import java.util.function.Consumer;
import java.util.*;
import java.util.function.Function;

/**
 *
 * @author SAMSUNG
 */
public class FileList {

    public void readFile(String filePath, Consumer<String> lineProcessor) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineProcessor.accept(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에 데이터 쓰기
    public void writeFile(String filePath, List<String> data, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 특정 조건에 따라 파일 내용 업데이트
    public void updateFile(String filePath, Function<String, String> updater) {
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                updatedLines.add(updater.apply(line)); // 업데이트된 라인 추가
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
