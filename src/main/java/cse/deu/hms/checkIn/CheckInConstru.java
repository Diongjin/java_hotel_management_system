/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.checkIn;

/**
 *
 * @author SAMSUNG
 */
public class CheckInConstru {

    private String id;          // 고유번호
    private String roomNumber;  // 객실번호
    private String guestName;   // 예약자 이름
    private String phone;       // 전화번호
    private String amount;      // 금액
    private String checkInDate; // 체크인 날짜
    private String checkOutDate;// 체크아웃 날짜
    private String paymentType; // 결제 유형

    // 매개변수 있는 생성자
    public CheckInConstru(String id, String roomNumber, String guestName, String phone, String amount,
            String checkInDate, String checkOutDate, String paymentType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.phone = phone;
        this.amount = amount;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentType = paymentType;
    }

    // 게터와 세터
    public String getUniqueId() {
        return id;
    }

    public void setUniqueId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return amount;
    }

    public void setPrice(String amount) {
        this.amount = amount;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return id + "\t" + roomNumber + "\t" + guestName + "\t" + phone + "\t"
                + amount + "\t" + checkInDate + "\t" + checkOutDate + "\t" + paymentType;
    }
}
