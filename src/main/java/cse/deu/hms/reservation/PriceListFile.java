/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.reservation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMSUNG
 */
public class PriceListFile extends JFrame {

    private JTextField roomNumberField; // 입력될 텍스트 필드 참조
    private String paths = System.getProperty("user.dir");  // 프로젝트 루트 경로
    private File roomPriceFile = new File(paths + "/src/roomPrice.txt"); // src폴더에 파일이 있음

    public PriceListFile(JTextField roomNumberField) {
        this.roomNumberField = roomNumberField;
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 가격 데이터
        String[] columns = {"층수", "가격"};
        Object[][] data = loadFloorPricesFromFile(roomPriceFile.getAbsolutePath());

        // JTable 생성
        JTable table = new JTable(new DefaultTableModel(data, columns));
        add(new JScrollPane(table)); // 스크롤 추가
        
        // 창 크기 고정
        setResizable(false);
    }

    private Object[][] loadFloorPricesFromFile(String filePath) {
        // 텍스트 파일에서 데이터를 읽어와 Object[][]로 반환
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            LinkedList<Object[]> dataList = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t"); // 쉼표를 기준으로 데이터 분리
                if (parts.length == 2) {
                    dataList.add(new Object[]{parts[0], parts[1]});
                }
            }
            return dataList.toArray(new Object[0][2]);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일을 읽는 중 오류가 발생했습니다");
            return new Object[0][0]; // 오류 발생 시 빈 데이터 반환
        }
    }
}
