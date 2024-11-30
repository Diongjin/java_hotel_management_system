/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.checkIn;

import java.io.*;
import java.util.*;
import cse.deu.hms.checkIn.AppConstants;

/**
 *
 * @author SAMSUNG
 */
public class CheckInFile {

    public List<CheckInConstru> loadReservations() throws IOException {
        List<CheckInConstru> reservations = new ArrayList<>();
        List<String> lines = readFile(AppConstants.reservationFile);
        for (String line : lines) {
            String[] data = line.split("\t");
            if (data.length >= 9) { // 데이터 길이 확인
                reservations.add(new CheckInConstru(
                        data[0], data[1], data[2], data[3],
                        data[5], data[6], data[7], data[8]
                ));
            }
        }
        return reservations;
    }

    // 예약 데이터를 파일에 저장
    public void saveReservations(List<String[]> reservations) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String[] reservation : reservations) {
            lines.add(String.join("\t", reservation));
        }
        writeFile(AppConstants.reservationFile, lines);
    }

    // 체크인 리스트로 이동
    public void moveToCheckInList(String[] reservationData) throws IOException {
        appendToFile(AppConstants.checkinFile, String.join("\t", reservationData));
    }

    // 체크아웃 리스트로 이동
    public void moveToCheckOutList(String[] checkInData) throws IOException {
        appendToFile(AppConstants.checkoutFile, String.join("\t", checkInData));
    }

    // 메뉴 사용 내역 읽기
    public List<String[]> loadMenuUsage(String roomNumber) throws IOException {
        List<String> lines = readFile(AppConstants.menupaymentFile);
        List<String[]> usage = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split("\t");
            if (data[0].trim().equals(roomNumber.trim())) { // 객실 번호 일치 확인
                usage.add(data); // 사용 내역 추가
            }
        }
        return usage;
    }

    // 공통 파일 읽기 메서드
    public List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    // 공통 파일 쓰기 메서드
    public void writeFile(String filePath, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // 공통 파일 추가 쓰기 메서드
    public void appendToFile(String filePath, String line) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        }
    }

    // 체크인 데이터를 객실 번호로 조회
    public CheckInConstru getCheckInData(String roomNumber) throws IOException {
        List<CheckInConstru> checkInList = loadCheckInList();
        for (CheckInConstru checkIn : checkInList) {
            if (checkIn.getRoomNumber().equals(roomNumber)) {
                return checkIn;
            }
        }
        return null;
    }

    // 체크인 리스트 불러오기
    public List<CheckInConstru> loadCheckInList() throws IOException {
        List<CheckInConstru> checkInList = new ArrayList<>();
        List<String> lines = readFile(AppConstants.checkinFile);
        for (String line : lines) {
            String[] data = line.split("\t");
            if (data.length >= 8) {
                checkInList.add(new CheckInConstru(
                        data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]
                ));
            }
        }
        return checkInList;
    }

    // 객실 사용 내역 비용 계산
    public int calculateUsageCharge(String roomNumber) throws IOException {
        int usageCharge = 0;
        List<String[]> menuUsage = loadMenuUsage(roomNumber);
        for (String[] usage : menuUsage) {
            usageCharge += Integer.parseInt(usage[2]); // 가격
        }
        return usageCharge;
    }

    public List<CheckInConstru> searchReservations(String keyword, String searchCategory) throws IOException {
        List<CheckInConstru> allReservations = loadReservations(); // 전체 예약 로드
        List<CheckInConstru> filteredReservations = new ArrayList<>();

        for (CheckInConstru reservation : allReservations) {
            boolean matches = false;

            // 검색 조건 확인
            if (keyword.isEmpty()) {
                matches = true; // 검색어가 비어 있으면 모든 데이터 추가
            } else if ("이름".equals(searchCategory)) {
                matches = reservation.getGuestName().contains(keyword); // 이름 검색
            } else if ("객실번호".equals(searchCategory)) {
                matches = reservation.getRoomNumber().equals(keyword); // 객실번호 검색
            }

            if (matches) {
                filteredReservations.add(reservation);
            }
        }
        return filteredReservations;
    }

    public List<String[]> loadRoomPrices() throws IOException {
        return loadFileData(AppConstants.roompriceFile);
    }

    public List<String[]> loadFileData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line.split("\t"));
            }
        }
        return dataList;
    }
}
