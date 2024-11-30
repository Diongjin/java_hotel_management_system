/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.deu.hms.AutomatedWork;

/**
 *
 * @author SAMSUNG
 */
public class RevenueResult {

    private final int occupancy;
    private final int roomRevenue;
    private final int restaurantRevenue;
    private final int totalRevenue;

    public RevenueResult(int occupancy, int roomRevenue, int restaurantRevenue, int totalRevenue) {
        this.occupancy = occupancy; // 점유율
        this.roomRevenue = roomRevenue; // 객실 수익
        this.restaurantRevenue = restaurantRevenue; // 식당 수익
        this.totalRevenue = totalRevenue;   // 총 수익
    }

    public int getOccupancyRate() {
        return occupancy;
    }

    public int getRoomRevenue() {
        return roomRevenue;
    }

    public int getRestaurantRevenue() {
        return restaurantRevenue;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }
}
