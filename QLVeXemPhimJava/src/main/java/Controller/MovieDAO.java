/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Movie;
import java.sql.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MovieDAO extends DatabaseConnection{
    public List<Movie> getAllMovies() throws SQLException, ClassNotFoundException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies"; // Chỉ lấy các bộ phim chưa bị xóa

        // Tạo kết nối và thực thi câu lệnh SQL
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Duyệt qua kết quả và tạo đối tượng Movie cho mỗi bản ghi
        while (rs.next()) {
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String movieDescription = rs.getString("movie_description");
            String movieTrailer = rs.getString("movie_trailer");
            int movieCens = rs.getInt("movie_cens");
            String movieGenres = rs.getString("movie_genres");
            Date movieRelease = rs.getDate("movie_release");
            int movieLength = rs.getInt("movie_length");
            String moviePoster = rs.getString("movie_poster");
            boolean isDeleted = rs.getBoolean("is_deleted");

            // Tạo đối tượng Movie và thêm vào danh sách
            Movie movie = new Movie(movieId, movieName, movieDescription, movieTrailer, movieCens, movieGenres, 
                                    movieRelease.toLocalDate(), movieLength, moviePoster, isDeleted);
            movies.add(movie);
        }
        return movies;
    }
    
    public Movie getAllMoviesById(String name) throws SQLException, ClassNotFoundException {
        Movie movie = null;
        String sql = "SELECT * FROM movies WHERE movie_name LIKE ? AND is_deleted = 0"; // Chỉ lấy phim chưa bị xóa

        // Kết nối cơ sở dữ liệu và thực thi câu truy vấn
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Gán giá trị cho tham số `?`
            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                // Nếu tìm thấy bản ghi
                if (rs.next()) {
                    int movieId = rs.getInt("movie_id");
                    String movieName = rs.getString("movie_name");
                    String movieDescription = rs.getString("movie_description");
                    String movieTrailer = rs.getString("movie_trailer");
                    int movieCens = rs.getInt("movie_cens");
                    String movieGenres = rs.getString("movie_genres");
                    Date movieRelease = rs.getDate("movie_release");
                    int movieLength = rs.getInt("movie_length");
                    String moviePoster = rs.getString("movie_poster");
                    boolean isDeleted = rs.getBoolean("is_deleted");

                    // Tạo đối tượng Movie
                    movie = new Movie(movieId, movieName, movieDescription, movieTrailer, movieCens, movieGenres,
                                      movieRelease.toLocalDate(), movieLength, moviePoster, isDeleted);
                }
            }
        }
        return movie; // Trả về Movie (hoặc null nếu không tìm thấy)
    }

    
    public List<Movie> getMovieIsRealsing() throws SQLException, ClassNotFoundException {
    List<Movie> movies = new ArrayList<>();
        String sql = "SELECT DISTINCT movies.* FROM movies JOIN schedule ON movies.movie_id = schedule.movie_id;"; // Chỉ lấy các bộ phim chưa bị xóa

        // Tạo kết nối và thực thi câu lệnh SQL
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Duyệt qua kết quả và tạo đối tượng Movie cho mỗi bản ghi
        while (rs.next()) {
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String movieDescription = rs.getString("movie_description");
            String movieTrailer = rs.getString("movie_trailer");
            int movieCens = rs.getInt("movie_cens");
            String movieGenres = rs.getString("movie_genres");
            Date movieRelease = rs.getDate("movie_release");
int movieLength = rs.getInt("movie_length");
            String moviePoster = rs.getString("movie_poster");
            boolean isDeleted = rs.getBoolean("is_deleted");

            // Tạo đối tượng Movie và thêm vào danh sách
            Movie movie = new Movie(movieId, movieName, movieDescription, movieTrailer, movieCens, movieGenres, 
                                    movieRelease.toLocalDate(), movieLength, moviePoster, isDeleted);
            movies.add(movie);
        }
        return movies;
    }
    public List<Movie> getMovieComingSoon() throws SQLException, ClassNotFoundException {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movies where GETDATE() < movie_release";

        // Tạo kết nối và thực thi câu lệnh SQL
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Duyệt qua kết quả và tạo đối tượng Movie cho mỗi bản ghi
        while (rs.next()) {
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String movieDescription = rs.getString("movie_description");
            String movieTrailer = rs.getString("movie_trailer");
            int movieCens = rs.getInt("movie_cens");
            String movieGenres = rs.getString("movie_genres");
            Date movieRelease = rs.getDate("movie_release");
            int movieLength = rs.getInt("movie_length");
            String moviePoster = rs.getString("movie_poster");
            boolean isDeleted = rs.getBoolean("is_deleted");

            // Tạo đối tượng Movie và thêm vào danh sách
            Movie movie = new Movie(movieId, movieName, movieDescription, movieTrailer, movieCens, movieGenres, 
                                    movieRelease.toLocalDate(), movieLength, moviePoster, isDeleted);
            movies.add(movie);
        }
        return movies;
    }
    public List<Movie> getMovieCanWacth() throws SQLException, ClassNotFoundException {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movies where GETDATE() > movie_release";

        // Tạo kết nối và thực thi câu lệnh SQL
        Connection conn = getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Duyệt qua kết quả và tạo đối tượng Movie cho mỗi bản ghi
        while (rs.next()) {
            int movieId = rs.getInt("movie_id");
            String movieName = rs.getString("movie_name");
            String movieDescription = rs.getString("movie_description");
            String movieTrailer = rs.getString("movie_trailer");
            int movieCens = rs.getInt("movie_cens");
            String movieGenres = rs.getString("movie_genres");
            Date movieRelease = rs.getDate("movie_release");
            int movieLength = rs.getInt("movie_length");
            String moviePoster = rs.getString("movie_poster");
            boolean isDeleted = rs.getBoolean("is_deleted");

            // Tạo đối tượng Movie và thêm vào danh sách
            Movie movie = new Movie(movieId, movieName, movieDescription, movieTrailer, movieCens, movieGenres, 
                                    movieRelease.toLocalDate(), movieLength, moviePoster, isDeleted);
            movies.add(movie);
        }
        return movies;
    }
    public boolean updateMovieById(int id, String name, String desc, String trailer,int cens, String genres, LocalDate date, int length, String poster) {
        String sql = "UPDATE movies SET movie_name = ?, movie_description = ?, movie_trailer = ?, movie_cens = ?, movie_genres = ?, movie_release = ?, movie_length = ?, movie_poster = ? WHERE movie_id = ? AND is_deleted = 0";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, desc);
            pstmt.setString(3, trailer);
            pstmt.setInt(4, cens);
            pstmt.setString(5, genres);
            pstmt.setDate(6, java.sql.Date.valueOf(date));
            pstmt.setInt(7, length);
            pstmt.setString(8, poster);
            pstmt.setInt(9, id);

            int result = pstmt.executeUpdate();
            return result > 0;
} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean isMovieNowShowing(int movieId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT movie_release FROM movies WHERE movie_id = ? AND is_deleted = 0";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Date movieReleaseDate = rs.getDate("movie_release");
                LocalDate today = LocalDate.now();
                // Kiểm tra nếu ngày phát hành nhỏ hơn hoặc bằng ngày hôm nay
                return !movieReleaseDate.toLocalDate().isAfter(today);
            }
        }
        return false; // Trả về false nếu không tìm thấy phim
    }

    public boolean addMovie(String name, String desc, String trailer, int cens, String genres, LocalDate date, int length, String poster) throws ClassNotFoundException {
        String sql = "INSERT INTO movies (movie_name, movie_description, movie_trailer, movie_cens, movie_genres, movie_release, movie_length, movie_poster, is_deleted) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 0)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, desc);
            pstmt.setString(3, trailer);
            pstmt.setInt(4, cens);
            pstmt.setString(5, genres);
            pstmt.setDate(6, java.sql.Date.valueOf(date));
            pstmt.setInt(7, length);
            pstmt.setString(8, poster);

            int rowsInserted = pstmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm phim: " + e.getMessage());
            return false;
        }
    }
    public boolean softDeleteMovieById(int id) {
        String sql = "UPDATE movies SET is_deleted = 1 WHERE movie_id = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();
            return result > 0;
        }
        catch (Exception ex) {
            
        }
        return false;
    }
    public boolean movieRestore(int id) {
        String sql = "UPDATE movies SET is_deleted = 0 WHERE movie_id = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();
            return result > 0;
        }
        catch (Exception ex) {
            
        }
        return false;
    }
public boolean deleteMovieForever(int movieId) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM movies WHERE movie_id = ?"; // Xóa bộ phim vĩnh viễn

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, movieId); // Gán giá trị movieId vào câu truy vấn

            int rowsAffected = stmt.executeUpdate(); // Thực thi câu truy vấn
            return rowsAffected > 0; // Nếu có bản ghi bị xóa, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu không có bản ghi bị xóa
    }
}