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
public class AccountFile {

    private final File accountFile;

    public AccountFile(String filePath) {
        this.accountFile = new File(filePath);
    }

    public boolean exists() {
        return accountFile.exists();
    }

    public List<String[]> readAccounts() throws IOException {
        List<String[]> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    accounts.add(new String[]{data[0].trim(), data[1].trim(), data[2].trim()});
                } else {
                    throw new IOException("Invalid data format: " + line);
                }
            }
        }
        return accounts;
    }

    public void writeAccountData(List<String[]> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile))) {
            for (String[] row : data) {
                writer.write(String.join("\t", row));
                writer.newLine();
            }
        }
    }

    // 계정 삭제
    public void deleteAccount(String uniqueCode, String id, String pass) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    // 삭제할 데이터와 일치하지 않는 경우만 유지
                    if (!data[0].trim().equals(uniqueCode) || !data[1].trim().equals(id) || !data[2].trim().equals(pass)) {
                        content.append(line).append(System.lineSeparator());
                    }
                }
            }
        }

        // 변경된 내용을 파일에 덮어쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile))) {
            writer.write(content.toString());
        }
    }

    public void updatePassword(String id, String oldPass, String newPass) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length == 3) {
                    // 비밀번호를 변경할 대상
                    if (data[1].trim().equals(id) && data[2].trim().equals(oldPass)) {
                        content.append(data[0]).append("\t") // 고유 문자
                                .append(data[1]).append("\t") // ID
                                .append(newPass).append(System.lineSeparator()); // 새로운 비밀번호
                    } else {
                        content.append(line).append(System.lineSeparator()); // 기존 데이터 유지
                    }
                }
            }
        }

        // 변경된 내용을 파일에 저장
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile))) {
            writer.write(content.toString());
        }
    }

    public boolean isIdDuplicate(String newId) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length >= 2) {
                    String existingId = data[1].trim();
                    if (existingId.equals(newId)) {
                        return true; // 중복 ID 발견
                    }
                }
            }
        }
        return false; // 중복 없음
    }

    // 계정 추가
    public void addAccount(String uniqueCode, String id, String pass) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile, true))) {
            writer.write(uniqueCode + "\t" + id + "\t" + pass);
            writer.newLine();
        }
    }
}
