
package Controller;

import Models.FoodDetails;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodDetailsDAO extends DatabaseConnection{
    // Thêm bản ghi mới vào bảng food_booking
    public boolean addFoodBooking(int bookingId, int userId, String foodName, double price, int quantity, String description) {
        String sql = "INSERT INTO food_booking (booking_id, user_id, food_name, total_price, quantity, description) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookingId);
            stmt.setInt(2, userId);
            stmt.setString(3, foodName);
            stmt.setDouble(4, price);
            stmt.setInt(5, quantity);
            stmt.setString(6, description);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public double getTotalFoodRevenueByMonth(int year, int month) throws SQLException, ClassNotFoundException {
        double totalRevenue = 0.0;
        String query = "SELECT SUM(fb.total_price) AS total_food_sales " +
                       "FROM food_booking fb " +
                       "WHERE fb.is_deleted = 0 " +
                       "AND YEAR(fb.booking_date) = ? " +
                       "AND MONTH(fb.booking_date) = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Thiết lập tham số cho câu lệnh SQL
            ps.setInt(1, year);
            ps.setInt(2, month);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalRevenue = rs.getDouble("total_food_sales");
                }
            }
        }

        return totalRevenue;
    }

    public List<FoodDetails> getFoodBookingByUserId(int userId) {
        List<FoodDetails> FoodDetails = new ArrayList<>();
        String sql = "SELECT * FROM food_booking WHERE user_id = ? AND is_deleted = 0";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FoodDetails foodBooking = new FoodDetails(
                            rs.getInt("foodbooking_id"),
                            rs.getInt("booking_id"),
                            rs.getInt("user_id"),
                            rs.getString("food_name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getDate("booking_date").toLocalDate(),
                            rs.getBoolean("is_deleted")
                    );
                    FoodDetails.add(foodBooking);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return FoodDetails;
    }
    
    // Lấy danh sách ngày đặt không trùng lặp theo userId
    public List<LocalDate> getDistinctBookingDatesByUserId(int userId) {
        List<LocalDate> distinctDates = new ArrayList<>();
        String sql = "SELECT DISTINCT CAST(booking_date AS DATE) AS booking_date " +
                     "FROM food_booking WHERE is_deleted = 0 AND user_id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId); // Truyền userId vào câu truy vấn
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    distinctDates.add(rs.getDate("booking_date").toLocalDate());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return distinctDates;
    }
    
    public List<LocalDate> getDistinctBookingDates() {
        List<LocalDate> distinctDates = new ArrayList<>();
        String sql = "SELECT DISTINCT CAST(booking_date AS DATE) AS booking_date " +
                     "FROM food_booking WHERE is_deleted = 0";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    distinctDates.add(rs.getDate("booking_date").toLocalDate());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return distinctDates;
    }

    // Lấy danh sách hóa đơn theo ngày đặt và userId
    public List<FoodDetails> getFoodBookingByDateAndUserId(LocalDate date, int userId) {
        List<FoodDetails> foodDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM food_booking WHERE user_id = ? AND CAST(booking_date AS DATE) = ? AND is_deleted = 0";
        
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setDate(2, Date.valueOf(date));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FoodDetails foodBooking = new FoodDetails(
                            rs.getInt("foodbooking_id"),
                            rs.getInt("booking_id"),
                            rs.getInt("user_id"),
                            rs.getString("food_name"),
                            rs.getDouble("total_price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getDate("booking_date").toLocalDate(),
                            rs.getBoolean("is_deleted")
                    );
                    foodDetailsList.add(foodBooking);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return foodDetailsList;
    }
    
    public List<FoodDetails> getFoodBookingByDate(LocalDate date) {
        List<FoodDetails> foodDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM food_booking WHERE CAST(booking_date AS DATE) = ? AND is_deleted = 0";
        
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(date));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FoodDetails foodBooking = new FoodDetails(
                            rs.getInt("foodbooking_id"),
                            rs.getInt("booking_id"),
                            rs.getInt("user_id"),
                            rs.getString("food_name"),
                            rs.getDouble("total_price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getDate("booking_date").toLocalDate(),
                            rs.getBoolean("is_deleted")
                    );
                    foodDetailsList.add(foodBooking);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return foodDetailsList;
    }

}
