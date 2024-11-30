/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.AutomatedWork;

import java.io.File;
import java.util.Date;

/**
 *
 * @author SAMSUNG
 */
public class RevenueService {

    private final String paths = System.getProperty("user.dir");  // 프로젝트 루트 경로
    private final File checkinFile = new File(paths + "/src/checkIn_list.txt");
    private final File checkoutFile = new File(paths + "/src/checkOut_list.txt");
    private final File menuPaymentFile = new File(paths + "/src/menu_payment.txt");
    private final File menuReservationFile = new File(paths + "/src/menu_reservation.txt");

    public RevenueResult calculateRevenue(Date startDate, Date endDate) {
        FileRead fileReaderUtil = new FileRead();

        int checkInCount = fileReaderUtil.getCountWithinPeriod(checkinFile, startDate, endDate, 5);
        int checkOutCount = fileReaderUtil.getCountWithinPeriod(checkoutFile, startDate, endDate, 5);

        int roomRevenue = fileReaderUtil.calculateRevenue(checkinFile, startDate, endDate, 4, 5);
        int restaurantRevenue1 = fileReaderUtil.calculateRevenue(menuPaymentFile, startDate, endDate, 2, 4);
        int restaurantRevenue2 = fileReaderUtil.calculateRevenue(menuReservationFile, startDate, endDate, 2, 4);

        int totalRestaurantRevenue = restaurantRevenue1 + restaurantRevenue2;
        int totalRevenue = roomRevenue + totalRestaurantRevenue;

        return new RevenueResult(checkInCount + checkOutCount, roomRevenue, totalRestaurantRevenue, totalRevenue);
    }
}
