/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.reservation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author SAMSUNG
 */
public class ReservationFile {

    private ArrayList<String> rawReservationData = new ArrayList<>();
    private String paths = System.getProperty("user.dir"); // 프로젝트 루트 경로
    private File reservationFile = new File(paths + "/src/reservation.txt"); // 예약 파일 경로

    public ReservationFile() {
        readFile(reservationFile);
    }

    // 파일을 읽어 예약 목록을 reservation_list에 저장
    private void readFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile(); // 파일이 없으면 새 파일 생성
                System.out.println("새로운 예약 파일을 생성했습니다: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("파일 생성 중 오류가 발생했습니다: " + e.getMessage());
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rawReservationData.add(line); // 파일 데이터를 ArrayList에 추가
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 예약 정보를 읽어서 ArrayList에 담아 반환
    public ArrayList<ReservationInfo> ReservationCheck() {
        ArrayList<ReservationInfo> reservationList = new ArrayList<>();
        for (String entry : rawReservationData) {
            String[] details = entry.split("\t");
            if (details.length < 9) {
                System.err.println("잘못된 데이터 형식: " + entry);
                continue;
            }

            try {
                reservationList.add(new ReservationInfo(
                        details[0], details[1], details[2], details[3],
                        details[4], details[5], details[6], details[7], details[8]
                ));
            } catch (NumberFormatException e) {
                System.err.println("숫자 변환 오류: " + entry);
            }
        }
        return reservationList;
    }

    public void saveReservations(ArrayList<ReservationInfo> reservations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservationFile, false))) {
            for (ReservationInfo reservation : reservations) {
                writer.write(reservation.toString());
                writer.newLine(); // 줄 바꿈
            }
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void deleteReservation(ArrayList<ReservationInfo> reservationList, String roomNumber) {
        boolean found = false;
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getRoomNumber().trim().equals(roomNumber.trim())) {
                reservationList.remove(i); // 리스트에서 삭제
                found = true;
                break;
            }
        }
        if (found) {
            saveReservations(reservationList); // 파일에 저장
        } else {
            System.err.println("객실번호를 찾을 수 없습니다");
        }
    }

    public void updateReservation(ArrayList<ReservationInfo> reservationList, int index, ReservationInfo updatedReservation) {
        if (index >= 0 && index < reservationList.size()) {
            reservationList.set(index, updatedReservation); // 특정 인덱스 데이터 업데이트
        } else {
            System.err.println("존재하지 않습니다.");
        }
    }
}
