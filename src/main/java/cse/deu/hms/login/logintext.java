/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.login;

import java.io.*;
import java.util.*;

/**
 *
 * @author SAMSUNG
 */
public class logintext {

    private ArrayList<String> id_list = new ArrayList<>();
    // user_list에 있는 정보를 저장하기 위한 arraylist
    private String paths = System.getProperty("user.dir");  // 프로젝트 루트 경로
    private File userFile = new File(paths + "/src/user_list.txt"); // src폴더에 파일이 있음

    public logintext() {
        readFile(userFile);
    }

    // 파일을 행 단위로 읽어와 ArrayList에 저장하는 메소드
    private void readFile(File file) {
        try (FileInputStream fis = new FileInputStream(file); 
                BufferedReader is = new BufferedReader(new InputStreamReader(fis))) {

            String line;
            while ((line = is.readLine()) != null) {
                id_list.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("파일 오류 발생");
        } catch (IOException e) {
            System.err.println("예외처리 오류 발생");
        }
    }

    // 사용자 ID와 비밀번호를 확인하는 메소드
    public int UserCheck(String cid, String cpass) {

        int login_return = -1;     // 로그인 실패 리턴값

        for (String entry : id_list) {
            String[] info_list = entry.split("\t");

            if (info_list.length >= 3 && info_list[1].equals(cid) && info_list[2].equals(cpass)) {
                // 관리자 로그인
                if (info_list[0].equals("M")) {
                    login_return = 1; // 관리자 코드
                } // 직원 로그인
                else if(info_list[0].equals("E")){
                    login_return = 99; // 직원 코드
                }
            }
        }
        return login_return;
    }
}
