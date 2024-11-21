/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.Roomservice;
import java.util.ArrayList;
/**
 *
 * @author user
 */
import javax.swing.table.DefaultTableModel;
public class MenuTableModel extends DefaultTableModel{
     public MenuTableModel() {
        super(new Object[][]{
                {false, "햄버거", "8000", "화려한 햄버거"},
                {false, "새우 볶음밥", "6000", "냉동 새우볶음밥"},
                {false, "봉지라면", "3500", "신라면"},
                {false, "치킨 너겟", "2800", "냉동 치킨너겟"},
                {false, "콜라", "1500", "코카콜라"}
        }, new String[]{"선택", "이름", "가격", "정보"});
    }
      @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class; // 첫 번째 열은 Boolean 타입
        }
        return String.class; // 나머지는 String 타입
    }
     public ArrayList<String[]> getSelectedItems() {
        ArrayList<String[]> selectedItems = new ArrayList<>();
        int rowCount = getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Boolean isSelected = (Boolean) getValueAt(i, 0);
            if (isSelected != null && isSelected) {
                String name = (String) getValueAt(i, 1);
                String price = (String) getValueAt(i, 2);
                selectedItems.add(new String[]{name, price});
            }
        }
        return selectedItems;
    }
}
