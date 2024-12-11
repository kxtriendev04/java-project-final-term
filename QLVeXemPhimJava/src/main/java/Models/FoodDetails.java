
package Models;

import java.sql.Date;
import java.time.LocalDate;

public class FoodDetails {
    private int foodBookingId;
    private int bookingId;
    private int userId;
    private String foodName;
    private double price;
    private int quantity;
    private String description;
    private LocalDate bookingDate;
    private boolean isDeleted;

    // Constructor, getters và setters
    public FoodDetails(int foodBookingId, int bookingId, int userId, String foodName, double price, int quantity, String description, LocalDate bookingDate, boolean isDeleted) {
        this.foodBookingId = foodBookingId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.bookingDate = bookingDate;
        this.isDeleted = isDeleted;
    }
    public FoodDetails(){
        
    }

    public int getFoodBookingId() {
        return foodBookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setFoodBookingId(int foodBookingId) {
        this.foodBookingId = foodBookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
}
