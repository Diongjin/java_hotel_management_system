/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.totalManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class MenuFile {

    private final File menuFile;

    public MenuFile(String filePath) {
        this.menuFile = new File(filePath);
    }

    public List<String[]> readMenuData() throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(menuFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("\t");
                data.add(row);
            }
        }
        return data;
    }

    public void writeMenuData(List<String[]> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuFile))) {
            for (String[] row : data) {
                writer.write(String.join("\t", row));
                writer.newLine();
            }
        }
    }

    public boolean isMenuDuplicate(String menuName, String menuType) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(menuFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3 && data[0].trim().equals(menuName) && data[2].trim().equals(menuType)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 메뉴 추가 메서드
    public void addMenu(String menuName, String menuPrice, String menuType) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuFile, true))) {
            writer.write(menuName + "\t" + menuPrice + "\t" + menuType);
            writer.newLine();
        }
    }

    public void updateMenu(String oldMenu, String oldPrice, String oldType,
            String newMenu, String newPrice, String newType) throws IOException {
        // 파일 내용 읽어서 메모리에 저장
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(menuFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    // 기존 데이터와 일치하면 수정된 데이터로 교체
                    if (data[0].trim().equals(oldMenu)
                            && data[1].trim().equals(oldPrice)
                            && data[2].trim().equals(oldType)) {
                        content.append(newMenu).append("\t")
                                .append(newPrice).append("\t")
                                .append(newType).append(System.lineSeparator());
                    } else {
                        // 기존 데이터를 유지
                        content.append(line).append(System.lineSeparator());
                    }
                }
            }
        }

        // 수정된 내용을 파일에 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuFile))) {
            writer.write(content.toString());
        }
    }

    public void deleteMenu(String menuName, String type) throws IOException {
        // 파일 내용을 메모리에 로드
        StringBuilder content = new StringBuilder();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(menuFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    String existingMenuName = data[0].trim();
                    String existingType = data[2].trim();

                    // 삭제 대상과 일치하지 않는 경우만 유지
                    if (!existingMenuName.equals(menuName) || !existingType.equals(type)) {
                        content.append(line).append(System.lineSeparator());
                    } else {
                        found = true; // 삭제할 메뉴를 찾음
                    }
                }
            }
        }

        // 삭제 대상이 없을 경우 예외 처리
        if (!found) {
            throw new IOException("삭제할 메뉴를 찾을 수 없습니다.");
        }

        // 수정된 내용을 파일에 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuFile))) {
            writer.write(content.toString());
        }
    }
}
