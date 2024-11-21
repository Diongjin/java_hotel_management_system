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

    private ArrayList<String> reservation_list = new ArrayList<>();
    // user_list에 있는 정보를 저장하기 위한 arraylist
    private String paths = System.getProperty("user.dir");  // 프로젝트 루트 경로
    private File reservationFile = new File(paths + "/src/reservation.txt"); // src폴더에 파일이 있음
    
    public ReservationFile() {
        readFile(reservationFile);
    }

    // 파일을 읽어 예약 목록을 reservation_list에 저장
    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reservation_list.add(line); // 예약 정보를 한 줄씩 추가
            }
        } catch (FileNotFoundException ex) {
            System.err.println("파일을 찾을 수 없습니다: " + ex.getMessage());
        } catch (IOException e) {
            System.err.println("IO 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 예약 정보를 읽어서 ArrayList에 담아 반환
    public ArrayList<String[]> ReservationCheck() {
        ArrayList<String[]> reservationList = new ArrayList<>();

        for (String entry : reservation_list) {
            // 예약 정보를 탭("\t")을 기준으로 나눠서 배열에 저장
            String[] reservationDetails = entry.split("\t");

            // 배열에 각 예약 정보를 추가
            reservationList.add(reservationDetails);
        }

        return reservationList;
    }
}
