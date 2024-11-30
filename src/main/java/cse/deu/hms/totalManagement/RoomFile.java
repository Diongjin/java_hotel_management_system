/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.totalManagement;

import java.util.*;
import java.io.*;

/**
 *
 * @author SAMSUNG
 */
public class RoomFile {

    private final File roomFile;

    public RoomFile(String filePath) {
        this.roomFile = new File(filePath);
    }

    public List<String[]> readRoomData() throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(roomFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("\t");
                data.add(row);
            }
        }
        return data;
    }

    public void writeRoomData(List<String[]> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(roomFile))) {
            for (String[] row : data) {
                writer.write(String.join("\t", row));
                writer.newLine();
            }
        }
    }

    public void updatePrice(String floorToEdit, String newPrice) throws IOException {
        // 파일 내용을 읽어서 메모리에 저장
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(roomFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 2) {
                    if (data[0].trim().equals(floorToEdit)) {
                        // 수정된 층수의 금액 반영
                        content.append(floorToEdit).append("\t").append(newPrice).append(System.lineSeparator());
                    } else {
                        // 기존 데이터 유지
                        content.append(line).append(System.lineSeparator());
                    }
                }
            }
        }

        // 수정된 내용을 파일에 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(roomFile))) {
            writer.write(content.toString());
        }
    }
}
