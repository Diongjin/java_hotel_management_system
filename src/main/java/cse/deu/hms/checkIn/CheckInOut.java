/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.deu.hms.checkIn;
// 내일 할거 체크인 버튼을 누르면 체크인으로 바뀌긴하지만 txt파일에는 저장도 되지않고 기록
// 또한 되지 않는다 그렇기 때문에 내일 이걸 진행하고 더 진행.

import cse.deu.hms.reservation.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMSUNG
 */
public class CheckInOut extends javax.swing.JFrame {

    private final String paths = System.getProperty("user.dir");  // 프로젝트 루트 경로
    private final File reservationFile = new File(paths + "/src/reservation.txt"); // src폴더에 파일이 있음

    /**
     * Creates new form checkIn
     */
    public CheckInOut() {
        initComponents();
        setLocationRelativeTo(null); // 창을 화면 중앙에 위치
        loadCheckinList(); // 프로그램 시작 시 체크인 리스트 로드

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkin = new javax.swing.JDialog();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        checkinButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        checkout = new javax.swing.JDialog();
        cancelButton1 = new javax.swing.JButton();
        CO_checkOutButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        useHistory = new javax.swing.JButton();
        checkout_searchButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        feedback_save = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        checkInButton = new javax.swing.JButton();
        checkOutButton = new javax.swing.JButton();

        cancelButton.setText("취소");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("체크인");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("예약 리스트");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "고유번호", "객실번호", "예약자", "전화번호", "금액", "체크인 날짜", "체크아웃 날짜", "결제 유형"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "이름", "객실번호" }));

        searchButton.setText("검 색");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        checkinButton.setText("체크인");
        checkinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinButtonActionPerformed(evt);
            }
        });

        changeButton.setText("예약 수정");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("체크인 리스트");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "고유번호", "객실 번호", "예약자", "전화번호", "금액", "결제 유형"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout checkinLayout = new javax.swing.GroupLayout(checkin.getContentPane());
        checkin.getContentPane().setLayout(checkinLayout);
        checkinLayout.setHorizontalGroup(
            checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(checkinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(checkinLayout.createSequentialGroup()
                        .addGroup(checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinLayout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(checkinLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(50, 50, 50)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        checkinLayout.setVerticalGroup(
            checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchButton)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cancelButton1.setText("취소");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        CO_checkOutButton.setText("체크아웃");
        CO_checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CO_checkOutButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("피드백");

        useHistory.setText("사용 내역");
        useHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useHistoryActionPerformed(evt);
            }
        });

        checkout_searchButton.setText("검 색");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("체크아웃");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "이름", "호실" }));

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("체크인 리스트");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "고유번호", "객실 번호", "예약자", "전화번호", "금액", "결제 유형"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        feedback_save.setText("피드백 저장");
        feedback_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedback_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkoutLayout = new javax.swing.GroupLayout(checkout.getContentPane());
        checkout.getContentPane().setLayout(checkoutLayout);
        checkoutLayout.setHorizontalGroup(
            checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(checkoutLayout.createSequentialGroup()
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(feedback_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(useHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CO_checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(checkoutLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkout_searchButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                .addContainerGap())
        );
        checkoutLayout.setVerticalGroup(
            checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkout_searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CO_checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedback_save, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton.setText("뒤로가기");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("체크인 / 체크아웃");

        checkInButton.setText("체크인");
        checkInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInButtonActionPerformed(evt);
            }
        });

        checkOutButton.setText("체크아웃");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void checkInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInButtonActionPerformed
        // TODO add your handling code here:
        checkin.setSize(1000, 600); // 너비 1000, 높이 300으로 설정
        checkin.setResizable(false); // 크기 변경 불가능하도록 설정 (선택 사항)
        checkin.setLocationRelativeTo(this);// 다이얼로그를 화면 중앙에 위치
        checkin.setVisible(true);// 다이얼로그 표시

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Load reservation data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(reservationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line into reservation details
                String[] reservationData = line.split("\t");

                // Ensure the data has the required length
                if (reservationData.length >= 8) {
                    String[] tableRow = new String[8];
                    tableRow[0] = reservationData[0]; // 고유번호
                    tableRow[1] = reservationData[1]; // 객실번호
                    tableRow[2] = reservationData[2]; // 예약자
                    tableRow[3] = reservationData[3]; // 전화번호
                    tableRow[4] = reservationData[5]; // 금액
                    tableRow[5] = reservationData[6]; // 체크인 날짜
                    tableRow[6] = reservationData[7]; // 체크아웃 날짜
                    tableRow[7] = reservationData[8]; // 결제 유형

                    // Add the row to the table
                    model.addRow(tableRow);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_checkInButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // 기본 프레임에서 체크인과 체크아웃 버튼중에 체크인을 눌렀을 때 나오는 프레임
        checkout.setSize(710, 470); // 너비 1000, 높이 600으로 설정
        checkout.setResizable(false); // 크기 변경 불가능하도록 설정 (선택 사항)
        checkout.setLocationRelativeTo(this);// 다이얼로그를 화면 중앙에 위치
        initializeCheckoutTable();
        loadCheckinList();
        checkout.setVisible(true);// 다이얼로그 표시
    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        checkin.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        checkout.dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void CO_checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CO_checkOutButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable4.getSelectedRow(); // 체크인 리스트에서 선택된 행 가져오기

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "체크아웃할 데이터를 선택하십시오.");
            return; // 선택된 행이 없으면 경고 메시지 출력
        }

        DefaultTableModel checkinModel = (DefaultTableModel) jTable4.getModel();

        // 선택된 행의 데이터 가져오기
        String[] checkoutData = new String[checkinModel.getColumnCount()];
        for (int i = 0; i < checkinModel.getColumnCount(); i++) {
            checkoutData[i] = (String) checkinModel.getValueAt(selectedRow, i);
        }

        // 체크인 리스트에서 데이터 제거
        checkinModel.removeRow(selectedRow);

        // 파일 업데이트
        try {
            // 1. checkIn_list.txt에서 체크아웃한 데이터 삭제
            File checkInFile = new File(paths + "/src/checkIn_list.txt");
            List<String> remainingCheckins = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(checkInFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.split("\t")[0].equals(checkoutData[0])) { // 고유번호 비교
                        remainingCheckins.add(line);
                    }
                }
            }

            // checkIn_list.txt 업데이트
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(checkInFile))) {
                for (String checkin : remainingCheckins) {
                    writer.write(checkin);
                    writer.newLine();
                }
            }

            // 2. checkOut_list.txt에 체크아웃 데이터 추가
            File checkOutFile = new File(paths + "/src/checkOut_list.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(checkOutFile, true))) { // true로 설정해서 덧붙이기
                writer.write(String.join("\t", checkoutData)); // 체크아웃 데이터 저장
                writer.newLine();
            }

            JOptionPane.showMessageDialog(this, "체크아웃 완료.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_CO_checkOutButtonActionPerformed

    private void useHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useHistoryActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String keyword = jTextField1.getText().trim(); // 검색어
        String searchCategory = (String) jComboBox1.getSelectedItem(); // 검색 기준 ("이름" 또는 "객실번호")

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // 기존 테이블 데이터 초기화

        try (BufferedReader reader = new BufferedReader(new FileReader(reservationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 예약 데이터를 읽어서 배열로 분리
                String[] reservationData = line.split("\t");

                // 데이터 구조가 유효한지 확인
                if (reservationData.length >= 9) { // 최소 9개의 필드가 있어야 함
                    boolean matches = false;

                    // 검색어가 비어 있으면 모든 데이터를 추가
                    if (keyword.isEmpty()) {
                        matches = true; // 모든 데이터를 추가
                    } else if ("이름".equals(searchCategory)) {
                        matches = reservationData[2].contains(keyword); // 예약자 이름 검색
                    } else if ("객실번호".equals(searchCategory)) {
                        matches = reservationData[1].equals(keyword); // 객실번호 검색
                    }

                    // 조건에 맞는 데이터를 테이블에 추가
                    if (matches) {
                        String[] tableRow = new String[8];
                        tableRow[0] = reservationData[0]; // 고유번호
                        tableRow[1] = reservationData[1]; // 객실번호
                        tableRow[2] = reservationData[2]; // 예약자
                        tableRow[3] = reservationData[3]; // 전화번호
                        tableRow[4] = reservationData[5]; // 금액
                        tableRow[5] = reservationData[6]; // 체크인 날짜
                        tableRow[6] = reservationData[7]; // 체크아웃 날짜
                        tableRow[7] = reservationData[8]; // 결제 유형

                        model.addRow(tableRow);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    private void checkinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinButtonActionPerformed
        // 체크인 프레임 안에서의 체크인 버튼
        int selectedRow = jTable1.getSelectedRow(); // 예약 리스트에서 선택된 행 가져오기

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "체크인할 예약을 선택하십시오.");
            return; // 선택된 행이 없으면 경고 메시지 출력
        }

        // 예약 리스트와 체크인 리스트의 테이블 모델 가져오기
        DefaultTableModel reservationModel = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel checkinModel = (DefaultTableModel) jTable3.getModel();

        // 선택된 행의 데이터 가져오기
        String[] selectedData = new String[reservationModel.getColumnCount()];
        for (int i = 0; i < reservationModel.getColumnCount(); i++) {
            selectedData[i] = (String) reservationModel.getValueAt(selectedRow, i);
        }

        // 체크인 리스트에 추가할 데이터 준비 (필요한 데이터만 추출)
        String[] checkinData = {
            selectedData[0], // 고유번호
            selectedData[1], // 객실 번호
            selectedData[2], // 예약자
            selectedData[3], // 전화번호
            selectedData[4], // 금액
            selectedData[7] // 결제 유형 (마지막 열)
        };

        checkinModel.addRow(checkinData); // 체크인 리스트 테이블에 추가

        // 예약 리스트에서 선택된 행 제거
        reservationModel.removeRow(selectedRow);

        // 파일 업데이트
        try {
            // 1. reservation.txt에서 체크인된 데이터 삭제
            List<String> remainingReservations = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(reservationFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.split("\t")[0].equals(selectedData[0])) { // 고유번호 비교
                        remainingReservations.add(line);
                    }
                }
            }

            // reservation.txt 업데이트
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservationFile))) {
                for (String reservation : remainingReservations) {
                    writer.write(reservation);
                    writer.newLine();
                }
            }

            // 2. checkIn_list.txt에 체크인된 데이터 추가
            File checkInFile = new File(paths + "/src/checkIn_list.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(checkInFile, true))) { // true로 설정해서 덧붙이기
                writer.write(String.join("\t", checkinData)); // 체크인 리스트 데이터 저장
                writer.newLine();
            }

            JOptionPane.showMessageDialog(this, "체크인 완료.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_checkinButtonActionPerformed

    private void loadCheckinList() {
        DefaultTableModel checkinModel = (DefaultTableModel) jTable4.getModel(); // jTable4는 체크인 리스트 테이블
        checkinModel.setRowCount(0); // 기존 데이터 초기화

        File checkInFile = new File(paths + "/src/checkIn_list.txt");

        if (checkInFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(checkInFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] checkinData = line.split("\t");

                    // 데이터가 열 구조와 맞는지 확인 (6개 열에 맞춰야 함)
                    if (checkinData.length >= 6) {
                        checkinModel.addRow(checkinData); // 테이블에 추가
                    } else {
                        System.err.println("파일 데이터 오류: " + line); // 디버깅 메시지
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "체크인 리스트를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    private void initializeCheckoutTable() {
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"고유번호", "객실 번호", "예약자", "전화번호", "금액", "결제 유형"}
        ));
    }

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        try {
            // ReservationManagement 클래스 인스턴스 생성 및 열기
            ReservationManagement rm = new ReservationManagement();

            // 체크인 프레임의 부모로 예약 수정 창을 설정
            rm.setLocationRelativeTo(this);

            // 예약 수정 창이 닫힐 때 체크인 데이터를 새로고침하도록 리스너 추가
            rm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    // 예약 수정 창이 닫히면 체크인 데이터를 새로고침
                    refreshReservationList();
                }
            });

            // 예약 수정 창 표시
            rm.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "예약 수정 화면을 여는 데 실패했습니다: " + e.getMessage());
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void refreshReservationList() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // 기존 데이터 초기화

        try (BufferedReader reader = new BufferedReader(new FileReader(reservationFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] reservationData = line.split("\t");
                if (reservationData.length >= 9) { // 데이터 유효성 확인
                    String[] tableRow = new String[8];
                    tableRow[0] = reservationData[0]; // 고유번호
                    tableRow[1] = reservationData[1]; // 객실번호
                    tableRow[2] = reservationData[2]; // 예약자
                    tableRow[3] = reservationData[3]; // 전화번호
                    tableRow[4] = reservationData[5]; // 금액
                    tableRow[5] = reservationData[6]; // 체크인 날짜
                    tableRow[6] = reservationData[7]; // 체크아웃 날짜
                    tableRow[7] = reservationData[8]; // 결제 유형

                    model.addRow(tableRow);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일을 다시 로드하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }


    private void feedback_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedback_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feedback_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckInOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CO_checkOutButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton changeButton;
    private javax.swing.JButton checkInButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JDialog checkin;
    private javax.swing.JButton checkinButton;
    private javax.swing.JDialog checkout;
    private javax.swing.JButton checkout_searchButton;
    private javax.swing.JButton feedback_save;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton useHistory;
    // End of variables declaration//GEN-END:variables
}
